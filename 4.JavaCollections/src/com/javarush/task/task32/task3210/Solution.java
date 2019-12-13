package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile raf = null;
        byte[] readText = new byte[text.length()];
        try {
            raf = new RandomAccessFile(fileName, "rw");
            raf.seek(number);
            raf.read(readText, 0, text.length());
            if (Arrays.equals(readText, text.getBytes())) {
                raf.seek(raf.length());
                raf.write("true".getBytes());
            } else {
                raf.seek(raf.length());
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
