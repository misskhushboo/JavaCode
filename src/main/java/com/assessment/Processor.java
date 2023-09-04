package com.assessment;

import java.util.*;
import java.util.stream.Collectors;

public class Processor {
//find word highest number of times: highest frequency. case sensitive. avoid the
    public static void main(String[] args){
        String str="He hit the ball so hard that the ball flew away and we lost the BALL";
        new Processor().process(str);
    }

    public void process(String str){
       // List<String> data=
        Map<String, Integer> data=getTokens(str);
       // data.entrySet().stream().
    }

    private Map<String, Integer> getTokens(String str){
        StringTokenizer tokenizer=new StringTokenizer(str);

        Map<String, Integer> map=new HashMap<>();

        while(tokenizer.hasMoreTokens()){
            String token=tokenizer.nextToken();

             if(token.equalsIgnoreCase("the"))
                 continue;

            if(map.containsKey(token)){
                Integer intValue=map.get(token);
                intValue++;
                map.put(token,intValue);
            }else{
                map.put(token,1);
            }

           // data.add(token.nextToken());
        }
        //System.out.println(tokens);
        map.forEach((e,k)->System.out.println(e+"|"+k));
        return map;
    }
}
