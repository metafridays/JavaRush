package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        FileInputStream fio = null;
        char[] chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
                'Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x',
                'y','z'};
        int counter = 0;
        try {
            fio = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (fio.available() > 0) {
                int tmp = fio.read();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == (char) tmp) counter++;
                }
            }
            System.out.println(counter);
            fio.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
