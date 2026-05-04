package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class IntegerDuplicates {

    public static void main(String[] args){
        new IntegerDuplicates().findDuplicates(new int[]{1,2,3,4,5,6,2,8,9}, 5);
    }

    private void findDuplicates(int[] inputArray, int bracket) {

        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0; i<inputArray.length; i++ ){

            if(map.containsKey(inputArray[i])){
               int oldIndex= map.get(inputArray[i]);

                if(i-oldIndex<=bracket){
                    System.out.println("Duplicate found "+inputArray[i]);
                    break;
                }
            }
            map.put(inputArray[i], i);
            if(map.size()>bracket)
                map.remove(inputArray[i-bracket]);
            map.entrySet().stream().forEach(e-> System.out.println(e.getKey()+" | "+e.getValue() +"\n"));
            System.out.println("-------------");
        }
    }
}
