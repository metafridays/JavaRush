package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        int num1 = Integer.parseInt(str1);
        if (num1 <= 0) throw new RuntimeException("Number is not valid");
        int num2 = Integer.parseInt(str2);
        if (num2 <= 0) throw new RuntimeException("Number is not valid");
        while (num2 != num1) {
            if (num2 > num1) num2-=num1;
            else num1-=num2;
        }
        System.out.println(num2);
    }
}
