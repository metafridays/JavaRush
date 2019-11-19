package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(fileName);
        bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            for (int i = s.length() - 1; i >= 0; i--) {
                System.out.print(s.substring(i,i+1));
                if (i == 0) System.out.println("");
            }
        }
        bufferedReader.close();
        fileReader.close();
    }
}
