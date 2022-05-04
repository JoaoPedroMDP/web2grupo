package utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class QueryFactory {
    private static final String INSERT = "INSERT INTO @(#) VALUES($);";
    private static final String DELETE = "DELETE FROM @ WHERE #;";
    private static final String UPDATE = "UPDATE @ SET # WHERE $;";
    private static final String SELECT = "SELECT @ FROM # WHERE $;";
    private static final String SIMPLE_SELECT = "SELECT @ FROM #;";

    public QueryFactory() {
    }

    private List<String> extractKeysFromMapInOrder(LinkedHashMap<String, Object> map) {
        List<String> keys = new ArrayList<String>();
        Iterator columns = map.entrySet().iterator();

        while(columns.hasNext()) {
            Entry<String, Object> entry = (Entry<String, Object>) columns.next();
            keys.add(entry.getKey());
        }

        return keys;
    }

    public String mount_insert(String tableName, ArrayList<String> columns) {
        String questionMarks = this.generateQuestionMarkSequence(columns.size());

        return INSERT.replace("@", tableName).replace("#", String.join(", ", columns)).replace("$", questionMarks);
    }

    public String mount_delete(String tableName, LinkedHashMap<String, Object> columns) {
        List<String> keys = this.extractKeysFromMapInOrder(columns);
        String toDeletePlaceholder = this.generateColumnAndPlaceholderString(keys, ", AND");
        
        return DELETE.replace("@", tableName).replace("#", toDeletePlaceholder);
    }

    public String mount_update(String tableName, LinkedHashMap<String, Object> data, LinkedHashMap<String, Object> filters) {
        List<String> keys = this.extractKeysFromMapInOrder(data);
        String toUpdatePlaceholder = this.generateColumnAndPlaceholderString(keys, ",");

        List<String> filtersKeys = this.extractKeysFromMapInOrder(filters);
        String filtersPlaceholder = this.generateColumnAndPlaceholderString( filtersKeys, ", AND");

        return UPDATE.replace("@", tableName)
            .replace("#", toUpdatePlaceholder)
            .replace("$", filtersPlaceholder);
    }

    public String mount_select(String tableName) {
        return SIMPLE_SELECT.replace("@", "*").replace("#", tableName);
    }

    public String mount_select(String tableName, LinkedHashMap<String, Object> filters) {
        List<String> filtersKeys = this.extractKeysFromMapInOrder(filters);
        String filtersPlaceholder = this.generateColumnAndPlaceholderString( filtersKeys, ", AND");

        return SELECT.replace("@", "*").replace("#", tableName).replace("$", filtersPlaceholder);
    }

    public String mount_select(String tableName, LinkedHashMap<String, Object> filters, ArrayList<String> columns) {
        List<String> filtersKeys = this.extractKeysFromMapInOrder(filters);
        String filtersPlaceholder = this.generateColumnAndPlaceholderString( filtersKeys, ", AND");

        String selectedColumns = String.join(", ", (CharSequence)columns);

        return SELECT.replace("@", selectedColumns)
            .replace("#", tableName)
            .replace("$", filtersPlaceholder);
    }

    private String generateColumnAndPlaceholderString(List<String> columns, String connector) {
        List<String> pairs = new ArrayList<String>();
        Iterator columnIter = columns.iterator();

        while(columnIter.hasNext()) {
            String column = (String)columnIter.next();
            pairs.add(column + "=?");
        }

        return String.join(connector + " ", pairs);
    }

    private String generateQuestionMarkSequence(Integer size) {
        String seq = "?";
        
        return seq.concat(
            new String(new char[size - 1]).replace("\u0000", ", ?")
        );
    }
}