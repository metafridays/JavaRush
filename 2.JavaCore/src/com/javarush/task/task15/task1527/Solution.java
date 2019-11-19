package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        s = s.substring(s.indexOf("?")+1,s.length());
        if (!s.substring(s.length()-1).equals("&")) s = s.concat("&");
        while (s.length() > 0) {
            list.add(s.substring(0,s.indexOf("&")));
            s = s.substring(s.indexOf("&")+1, s.length());
        }
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            if (s.contains("=")) System.out.print(s.substring(0, s.indexOf("=")));
            else System.out.print(s);
            if (i < list.size() - 1) System.out.print(" ");
        }
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            if (s.contains("obj")) {
                System.out.println();
                s = s.substring(s.indexOf("=") + 1, s.length());
                try {
                    alert(Double.parseDouble(s));
                } catch (Exception e) {
                    alert(s);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
