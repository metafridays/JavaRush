package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        List<String> fileArray1 = new ArrayList<>();
        List<String> fileArray2 = new ArrayList<>();
        FileReader fileReader = new FileReader(file1);
        reader = new BufferedReader(fileReader);
        while (reader.ready()) fileArray1.add(reader.readLine());
        fileReader = new FileReader(file2);
        reader = new BufferedReader(fileReader);
        while (reader.ready()) fileArray2.add(reader.readLine());
        reader.close();
        fileReader.close();
        int array1marker = 0;
        int array2marker = 0;
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
//        Cut the digit from line
//        for fileArray1 and fileArray2
//        and put it to array1 and array2
        for (String s : fileArray1) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(s);
            matcher.find();
            System.out.println(Integer.parseInt(s.subSequence(matcher.start(), matcher.end()).toString()));
        }
        for (String s : fileArray2) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(s);
            matcher.find();
            System.out.println(Integer.parseInt(s.subSequence(matcher.start(), matcher.end()).toString()));
            array2.add(Integer.parseInt(s.subSequence(matcher.start(), matcher.end()).toString()));
        }
//        array1marker = 0;
//        array2marker = 0;
        int counter = Math.max(array1.size(), array2.size());
        for (int i = 0; i< counter; i++) {
            if (!(array1.size() > i)) array1.add(null);
            if (!(array2.size() > i)) array2.add(null);
        }
        for (int i = 0; i < counter; i++) {
            if (array1.get(i) == array2.get(i)) {
                LineItem lineItem = new LineItem(Type.SAME, fileArray1.get(i));
                lines.add(lineItem);
            }

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
