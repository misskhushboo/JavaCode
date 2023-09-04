package com.discussion;

import java.util.*;

public class AssessmentTwo {

    public static void main(String[] args){
        new AssessmentTwo().appendZerosAtEnd();
    }

    public void appendZerosAtEnd(){

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(6);
        int count=0;
        List<Integer> modifiedList=new ArrayList<>();

        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            Integer value=it.next();
            if(value==0){
                count++;
            }
            else
                modifiedList.add(value);
        }

        for (;count>0;count--) {
            modifiedList.add(0);
        }
        modifiedList.forEach(System.out::println);
    }

    public void process(){
        Map<String, Integer> map=new HashMap<>();
        map.put("A", 20);
        map.put("G", 5);
        map.put("C", 8);
        map.put("B", 2);
        map.put("D", 2);
        map.put("I", 2);

       // map.entrySet().stream().sorted().collect(Collectors.toMap());
    }
}
