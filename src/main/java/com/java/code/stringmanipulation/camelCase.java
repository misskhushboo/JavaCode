package com.java.code.stringmanipulation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class camelCase {


    //oneTwoThree
    //i=3/6
    //last=3/6

    public int camelcase(String str){
        char[] strArray=str.toCharArray();
        int i=0;
        int lastCapLetterIndex=0;
        List<String> result=new ArrayList<>();


        for(char strValue: strArray){

            //Character.isUpperCase(strValue);
            if(strValue>=65 && strValue<=90){
                if(lastCapLetterIndex==0){
                    result.add(str.substring(0,i));
                }else{
                    result.add(str.substring(lastCapLetterIndex,i));
                }
                lastCapLetterIndex=i;
            }
            i++;
        }
        result.add(str.substring(lastCapLetterIndex,i-1));
        return result.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = new camelCase().camelcase(s);

       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();
        System.out.println(result);
        bufferedReader.close();

    }
}
