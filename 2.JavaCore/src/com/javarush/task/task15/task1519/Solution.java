package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double double1;
        String string1;
        short short1;
        Integer integer1;
        string1 = reader.readLine();
        while (!string1.equals("exit")) {
            boolean check = false;
            try {
                if (string1.contains(".")) {
                    double1 = Double.parseDouble(string1);
                    print(double1);
                    check = true;
                }
            } catch (NumberFormatException e) {}

            try {
                if (Integer.parseInt(string1) > 0 && Integer.parseInt(string1) < 128) {
                    short1 = Short.parseShort(string1);
                    print(short1);
                    check = true;
                }
            } catch (NumberFormatException e) {}

            try {
                if (Integer.parseInt(string1) <= 0 || Integer.parseInt(string1) >= 128) {
                    integer1 = Integer.parseInt(string1);
                    print(integer1);
                    check = true;
                }
            } catch (NumberFormatException e) {}

            if (!check) print(string1);
            string1 = reader.readLine();

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
