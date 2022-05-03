package interfaces;

import java.util.LinkedHashMap;

public interface Tableable {
    public String[] getColumns();
    public LinkedHashMap<String, Object> toTable();
}
