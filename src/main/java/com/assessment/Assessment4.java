package com.assessment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assessment4 {
    //{"papaya", "apple", "apple", "banana","apple", "orange", "banana","apple","banana",  "papaya"}

    //{apple=4, banana=3, papaya=2, orange=1}

    public static void main(String[] args){
        List<String> inputValues= List.of("papaya", "apple", "apple", "banana","apple", "orange", "banana","apple","banana",  "papaya");
        new Assessment4().process(inputValues);
    }

    public void process(List<String> inputValues){
        inputValues.forEach(System.out::println);
        Map<String, Integer> map=new HashMap<>();

        for(String str:inputValues){
            if(map.containsKey(str)){
                int count=map.get(str);
                count++;
                map.put(str,count);
            }
            else
                map.put(str,1);
        }
        Map<String, Integer> map1=inputValues.stream().collect(Collectors.groupingBy()).collect(Collectors.toMap());
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(k->System.out.println(k.getKey()+"|"+k.getValue()));
        //inputValues.stream().
       // map.entrySet().forEach(k->System.out.println(k.getKey()+"|"+k.getValue()));
    }

}
