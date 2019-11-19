package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        int length1;
        int length2;
        if (fileInputStream.available() % 2 > 0)  {
            length1 = fileInputStream.available() / 2 + 1;
            length2 = fileInputStream.available() / 2;
        }
        else {
            length1 = fileInputStream.available() / 2;
            length2 = length1;
        }
        byte[] buffer = new byte[length1];
        fileInputStream.read(buffer);
        fileOutputStream.write(buffer);
        fileOutputStream.close();
        buffer = new byte[length2];
        fileOutputStream = new FileOutputStream(file3);
        fileInputStream.read(buffer);
        fileOutputStream.write(buffer);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
