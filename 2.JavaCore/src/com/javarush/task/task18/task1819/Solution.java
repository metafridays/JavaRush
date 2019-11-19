package com.javarush.task.task18.task1819;

/* 
Объединение файлов
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
        reader.close();
        FileInputStream fio = new FileInputStream(file1);
        byte[] buf = new byte[fio.available()];
        fio.read(buf);
        fio.close();
        fio = new FileInputStream(file2);
        FileOutputStream fout = new FileOutputStream(file1);
        while (fio.available() > 0) fout.write(fio.read());
        fio.close();
        fout.write(buf);
        fout.close();
    }
}
