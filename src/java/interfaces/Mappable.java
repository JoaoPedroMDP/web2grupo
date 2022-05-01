package interfaces;

import java.util.LinkedHashMap;

public interface Mappable {
    void fromMap(LinkedHashMap<String, Object> data);
    LinkedHashMap<String, Object> toMap();
}
