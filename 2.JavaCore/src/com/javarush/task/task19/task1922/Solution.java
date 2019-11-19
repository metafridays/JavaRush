package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(fileName);
        bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            String stringFromFile = bufferedReader.readLine();
            String[] strings = stringFromFile.split(" ");
            int counter = 0;
            for (String s : strings) {
                for (String word : words) {
                    if (s.equals(word)) counter++;
                }
            }
            if (counter == 2) System.out.println(stringFromFile);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
