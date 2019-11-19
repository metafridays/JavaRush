package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            if (!treeSet.contains(tmp)) treeSet.add(tmp);
        }
        fileInputStream.close();
        for (int i:
             treeSet) {
            System.out.print(i + " ");
        }
    }
}
