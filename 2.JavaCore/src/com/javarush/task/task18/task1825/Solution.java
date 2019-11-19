package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileList = new ArrayList<>();
        String str = "end";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!str.equals("end")) {
            fileList.add(str);
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileName = getName(fileList);
        fileList = listSort(fileList);
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileOutputStream fw = new FileOutputStream(file);
            for (String fName : fileList) {
                //System.out.println(fName);
                FileInputStream fr = new FileInputStream(fName);
                byte[] bytes = new byte[fr.available()];
                fr.read(bytes);
                fw.write(bytes);
                fr.close();
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getName(ArrayList<String> list) {
        Pattern pattern = Pattern.compile(".+?\\.\\D\\D\\D");
        Matcher matcher = pattern.matcher(list.get(0));
        matcher.find();
        return list.get(0).substring(matcher.start(), matcher.end());
    }

    private static ArrayList<String> listSort(ArrayList<String> list) {
        Pattern pattern = Pattern.compile("\\d+$" );
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i <= list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                Matcher matcher = pattern.matcher(list.get(j));
                matcher.find();
                String str = (list.get(j).substring(matcher.start(), matcher.end()));
                if (i == Integer.parseInt(str)) tmp.add(list.get(j));
            }
        }
        return tmp;
    }
}
