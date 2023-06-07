package com.java.code;

import java.util.Scanner;

public class StandardInputOutput {

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String myString=scanner.next();
        System.out.println("String input:"+myString);

        int intInput=scanner.nextInt();
        System.out.println("Int input:"+intInput+ "|"+Integer.sum(intInput,intInput));
        scanner.close();
    }
}
