package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        int tmp = 0;
        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 44) tmp++;
        }
        fileInputStream.close();
        System.out.println(tmp);
    }
}
