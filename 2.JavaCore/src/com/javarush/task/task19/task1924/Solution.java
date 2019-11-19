package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            Pattern pattern = Pattern.compile("\\b\\d{1,2}\\b");
            Matcher matcher = pattern.matcher(s);
            int matchPoint = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                if (matcher.find()) {
                    System.out.print(s.substring(matchPoint, matcher.start()));
                    if (map.containsKey(Integer.parseInt(s.substring(matcher.start(), matcher.end())))) {
                        System.out.print(map.get(Integer.parseInt(s.substring(matcher.start(), matcher.end()))));
                    }
                    else System.out.print(s.substring(matcher.start(), matcher.end()));
                    matchPoint = matcher.end();
                }
                if (matcher.hitEnd()) {
                    if (matchPoint != 0) {
                        System.out.println(s.substring(matchPoint));
                    }
                    break;
                }
            }
            if (matchPoint == 0) System.out.println(s);
            matchPoint = 0;
        }
        bufferedReader.close();
        fileReader.close();
    }
}
