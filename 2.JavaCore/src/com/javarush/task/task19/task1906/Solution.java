package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = null;
        String outFile = null;
        try {
            inFile = reader.readLine();
            outFile = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(inFile);
            fileWriter = new FileWriter(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 1;
        try {
            while (fileReader.ready()) {
                if (i % 2 == 0) fileWriter.write(fileReader.read());
                else fileReader.read();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
