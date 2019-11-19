package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis;
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (;;) {
            try {
                fis = new FileInputStream(str);
            } catch (FileNotFoundException e) {
                System.out.println(str);
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            }
            try {
                fis.close();
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
