package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {

    static List<String> lines = new ArrayList<String>();

    static {
        String s;
        try {
            FileInputStream fileInputStream = new FileInputStream(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            while ((s = reader.readLine()) != null) {
                lines.add(s);
                }
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(lines.toString());
    }
}
