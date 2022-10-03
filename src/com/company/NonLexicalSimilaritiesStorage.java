package com.company;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NonLexicalSimilaritiesStorage {
    private final Map<String, String> storage = new HashMap<>();

    public NonLexicalSimilaritiesStorage() {
        storage.put("бетон с присадкой", "цемент");
    }

    public boolean contains(String str1, String str2) {
        String valueFound = storage.get(str1);
        if (str2.equals(valueFound)) {
            return true;
        }
        valueFound = storage.get(str2);
        return str1.equals(valueFound);
    }

    public void addPair(String str1, String str2) {
        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);
        storage.put(str1, str2);
    }
}
