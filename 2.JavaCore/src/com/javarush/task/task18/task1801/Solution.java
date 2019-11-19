package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        while (tmp != -1) {
            tmp = fileInputStream.read();
            if (tmp > max) max = tmp;
        }
        fileInputStream.close();
        reader.close();
        System.out.println(max);
    }
}
