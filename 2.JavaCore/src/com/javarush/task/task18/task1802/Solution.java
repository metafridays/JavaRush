package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int min = Integer.MAX_VALUE;
        int tmp = 0;
        while (fileInputStream.available() > 0) {
            tmp = fileInputStream.read();
            if (tmp < min) min = tmp;
        }
        fileInputStream.close();
        reader.close();
        System.out.println(min);
    }
}
