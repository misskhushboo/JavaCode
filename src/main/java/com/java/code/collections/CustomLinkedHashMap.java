package com.java.code.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomLinkedHashMap {
        public static void main(String[] args) {

            Map<String, Integer> lmap = new LinkedHashMap<>();
            lmap.put("key5", 6);
            lmap.put("key2", 5);
            lmap.put("key3", 4);
            lmap.put("key5", 3);
            System.out.println(lmap);
        }
}
