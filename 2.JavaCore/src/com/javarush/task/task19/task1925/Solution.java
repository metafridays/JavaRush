package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        boolean firstWord = true;
        while (bufferedReader.ready()) {
            String[] strings = bufferedReader.readLine().split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].length() > 6 && !firstWord ) {
                    bufferedWriter.write("," + strings[i]);
                }
                if (strings[i].length() > 6 && firstWord) {
                    bufferedWriter.write(strings[i]);
                    firstWord = false;
                }
            }
        }


        bufferedReader.close();
        bufferedWriter.close();
        fileReader.close();
        fileWriter.close();
    }
}
