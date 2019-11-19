package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(file1));
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(file2));
        String input = reader.readLine();
        reader.close();
        Pattern p = Pattern.compile("\\b\\d+\\b");
        Matcher m = p.matcher(input);
        while (m.find()) {
            outputStream.write(m.group());
            outputStream.write(" ");
        }
        outputStream.close();
    }
}
