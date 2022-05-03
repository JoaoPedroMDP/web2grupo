package br.ufpr.tads.web2.interfaces;

import java.util.LinkedHashMap;

public interface Mappable {
    void fromMap(LinkedHashMap<String, String> data);
    LinkedHashMap<String, String> toMap();
    LinkedHashMap<String, String> toMap(Boolean allString);
}
