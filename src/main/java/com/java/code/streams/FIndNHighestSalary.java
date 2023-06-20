package com.java.code.streams;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FIndNHighestSalary {

    public static void main(String[] args){
        new FIndNHighestSalary().process();
    }

    private void process() {

        Map<String,Integer> data=new HashMap<>();
        data.put("A",2500);
        data.put("B",1200);
        data.put("C",1000);
        data.put("D",3000);
        data.put("E",4500);
        data.put("F",5000);
        data.put("G",4500);
        data.put("H",2500);

        //sorts the map on value basis -Ascending order
        List ascendingOrderData=data.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        System.out.println("Map data in ascending order:"+ascendingOrderData);

        List descendingOrderData=data.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
        System.out.println("Map data in ascending order:"+descendingOrderData);
    }
}
