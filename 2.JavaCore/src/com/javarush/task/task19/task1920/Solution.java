package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        TreeMap<String, Double> treeMap= new TreeMap<>();
        double max = 0;
        while (reader.ready()) {
            String[] lines = reader.readLine().split(" ");
            if (treeMap.containsKey(lines[0])) treeMap.put(lines[0], treeMap.get(lines[0]) + Double.parseDouble(lines[1]));
            else treeMap.put(lines[0], Double.parseDouble(lines[1]));
        }
        fileReader.close();
        reader.close();
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            if (entry.getValue() > max) max = entry.getValue();
        }
        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            if (entry.getValue() == max) System.out.println(entry.getKey());
        }
    }
}
