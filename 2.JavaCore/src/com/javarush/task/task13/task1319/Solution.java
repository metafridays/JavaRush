package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String outString;
        FileOutputStream outStream = new FileOutputStream(fileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
        do {
            outString = reader.readLine();
            writer.write(outString + "\n");
        } while (!outString.equals("exit"));
        writer.close();
        reader.close();
    }
}
