package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDir = new File(root);
        List<String> list = new ArrayList<>();
        ArrayDeque<File> deque = new ArrayDeque<File>(new ArrayList<>(Arrays.asList(rootDir.listFiles())));
        while (!deque.isEmpty()) {
            File file = deque.remove();
            if (file.isDirectory()) {
                if (file.listFiles() != null) {
                    deque.addAll(new ArrayList<>(Arrays.asList(file.listFiles())));
                }
            }
            if (file.isFile()) list.add(file.getAbsolutePath());
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            for (String s : getFileTree("C:\\Users\\metaf\\Documents")) System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
