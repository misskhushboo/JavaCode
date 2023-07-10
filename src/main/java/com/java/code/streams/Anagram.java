package com.java.code.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

    public static void main(String[] args) {
        boolean result=new Anagram().problemStatement("Hello", "Olleh");
        System.out.println("Result="+result);
    }

    private boolean problemStatement(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.length() > 50 || str2.length() > 50) {
            return false;
        }
        if (str1.length() < 1 || str2.length() < 1) {
            return false;
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            int count = 1;
            if (map1.containsKey(String.valueOf(ch))) {
                count = map1.get(String.valueOf(ch));
                count++;
            }
            map1.put(String.valueOf(ch).toLowerCase(), count);
        }
        for (char ch : str2.toCharArray()) {
            int count = 1;
            if (map2.containsKey(String.valueOf(ch))) {
                count = map2.get(String.valueOf(ch));
                count++;
            }
            map2.put(String.valueOf(ch).toLowerCase(), count);
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();

            if(map2.containsKey(key)) {      //if same key exists in both the collections
                int value1 = entry.getValue();
                int value2 = map2.get(key);

                if(value1 != value2)
                    return false;
            }else{
                return false;
            }
        }
        return true;
    }
}
