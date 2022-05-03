package br.ufpr.tads.web2.util;

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

    private List<String> extractKeysFromMapInOrder(LinkedHashMap<String, String> map) {
        List<String> keys = new ArrayList<String>();
        Iterator columns = map.entrySet().iterator();

        while(columns.hasNext()) {
            Entry<String, String> entry = (Entry<String, String>) columns.next();
            keys.add(entry.getKey());
        }

        return keys;
    }

    public String mount_insert(String tableName, ArrayList<String> columns) {
        return INSERT.replace("@", tableName).replace("#", String.join(", ", columns)).replace("$", this.generateQuestionMarkSequence(columns.size()));
    }

    public String mount_delete(String tableName, LinkedHashMap<String, String> columns) {
        return DELETE.replace("@", tableName).replace("#", this.generateColumnAndPlaceholderString(this.extractKeysFromMapInOrder(columns), ", AND"));
    }

    public String mount_update(String tableName, LinkedHashMap<String, String> data, LinkedHashMap<String, String> filters) {
        return UPDATE.replace("@", tableName).replace("#", this.generateColumnAndPlaceholderString(this.extractKeysFromMapInOrder(data), ",")).replace("$", this.generateColumnAndPlaceholderString(this.extractKeysFromMapInOrder(filters), ", AND"));
    }

    public String mount_select(String tableName) {
        return SIMPLE_SELECT.replace("@", "*").replace("#", tableName);
    }

    public String mount_select(String tableName, LinkedHashMap<String, String> filters) {
        return SELECT.replace("@", "*").replace("#", tableName).replace("$", this.generateColumnAndPlaceholderString(this.extractKeysFromMapInOrder(filters), " AND"));
    }

    public String mount_select(String tableName, LinkedHashMap<String, String> filters, ArrayList<String> columns) {
        return SELECT.replace("@", String.join(", ", (CharSequence)columns)).replace("#", tableName).replace("$", this.generateColumnAndPlaceholderString(this.extractKeysFromMapInOrder(filters), " AND"));
    }

    private String generateColumnAndPlaceholderString(List<String> columns, String connector) {
        List<String> pairs = new ArrayList<String>();
        Iterator var4 = columns.iterator();

        while(var4.hasNext()) {
            String column = (String)var4.next();
            pairs.add(column + "=?");
        }

        return String.join(connector + " ", pairs);
    }

    private String generateQuestionMarkSequence(int size) {
        String seq = "?";
        return seq.concat((new String(new char[size - 1])).replace("\u0000", ", ?"));
    }
}