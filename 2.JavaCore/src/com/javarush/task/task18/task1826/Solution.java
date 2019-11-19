package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        switch (args[0]) {
            case ("-e") : {
                encrypt(args[1], args[2]);
                break;
            }
            case ("-d") : {
                decrypt(args[1], args[2]);
                break;
            }
        }
    }

    private static void encrypt(String fin, String fout) {
        try {
            FileInputStream fis = new FileInputStream(fin);
            FileOutputStream fos = new FileOutputStream(fout);
            fos.write(101);
            fos.write(110);
            fos.write(99);
            while (fis.available() > 0) fos.write(fis.read()^85);
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decrypt(String fin, String fout) {
        try {
            FileInputStream fis = new FileInputStream(fin);
            FileOutputStream fos = new FileOutputStream(fout);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            for (int i = 3; i < bytes.length; i++) bytes[i] ^= 85;
            fos.write(bytes, 3, bytes.length - 3);
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
