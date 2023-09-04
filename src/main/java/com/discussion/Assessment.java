package com.discussion;

import java.util.ArrayList;
import java.util.List;

public class Assessment {

    public static void main(String[] args){
        new Assessment().assess();
    }
    public void assess(){

        List<Integer> list=List.of(2,0,5,0,3,9,0,1,2);
        List<Integer> modifiedList=new ArrayList<>();

        for(Integer value:list){
            if(value==0){
                modifiedList.add(0,value);
            }
            else modifiedList.add(value);
        }
        modifiedList.forEach(e->System.out.println(e));
    }
   // Input - {2,0,5,0,3,9,0,1,2}
    //Output - {0,0,0,2,5,3,9,1,2}
}
