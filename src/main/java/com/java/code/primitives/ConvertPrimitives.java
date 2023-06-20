package com.java.code.primitives;

import java.util.Scanner;

public class ConvertPrimitives {

    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int inputValue=scanner.nextInt();
        scanner.close();

        String strValue=String.valueOf(inputValue);
        System.out.println("Good job");
    }
}
