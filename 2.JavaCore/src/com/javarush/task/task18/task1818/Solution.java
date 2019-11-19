package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOut = reader.readLine();
        String fileIn1 = reader.readLine();
        String fileIn2 = reader.readLine();
        FileOutputStream fout = new FileOutputStream(fileOut);
        FileInputStream fin = new FileInputStream(fileIn1);
        while (fin.available() > 0) {
            fout.write(fin.read());
        }
        fin.close();
        fin = new FileInputStream(fileIn2);
        while (fin.available() > 0) {
            fout.write(fin.read());
        }
        fin.close();
        fout.close();
        reader.close();
    }
}
