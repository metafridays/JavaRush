package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        int counter = 0;
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            for (String s1 : strings) {
                if (s1.contains("1")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("2")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("3")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("4")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("5")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("6")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("7")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("8")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("9")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                        continue;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                        continue;
                    }
                }
                if (s1.contains("0")) {
                    if (counter == 0) {
                        bufferedWriter.write(s1);
                        counter++;
                    }
                    else {
                        bufferedWriter.write(" " + s1);
                        counter++;
                    }
                }
            }
        }
        bufferedReader.close();
        fileReader.close();
        bufferedWriter.close();
        fileWriter.close();
    }
}
