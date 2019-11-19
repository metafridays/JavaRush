package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(file1));
        //int id = Integer.parseInt(args[0]);
        while (reader.ready()) {
            String tmp = reader.readLine();
            if (tmp.startsWith(args[0]+" ")) System.out.println(tmp);
        }
        reader.close();
    }
}
