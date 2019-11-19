package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);
        int[] freq = new int[128];
        while (fis.available() > 0) {
            freq[fis.read()]++;
        }
        fis.close();
        char c = 0;
        for (int b : freq) {
            if (b != 0) System.out.println(c + " " + b);
            c++;
        }
    }
}
