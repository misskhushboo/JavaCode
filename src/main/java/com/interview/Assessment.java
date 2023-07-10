package com.interview;

import java.util.HashMap;
import java.util.Map;

public class Assessment {

    public static void main(String[] args){
        int[] arr=[1,2,3,4,5,6,7,8];
        //boolean existsOrNot=new Assessment().findSum(arr,14);
        boolean existsOrNot=new Assessment().findSumInMap();
    }

    public boolean findSum(int arr[], int sum){
        int i=0;
        for(int value:arr){         //1
            for(int value2 =i+1 ; value2<arr.length ; value2++) {  //
                if (value + arr[value2] == sum) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }


    public boolean findSumInMap(){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);
        map.put(6,6);
        int sum =6;

        for(Map.Entry entrySet:map){
            Integer key=(Integer) entrySet.getKey();
            Integer value =map.get(key);
        }
    }
}
