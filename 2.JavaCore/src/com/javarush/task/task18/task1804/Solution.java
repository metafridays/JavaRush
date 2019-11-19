package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        HashMap<Integer, Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            if (map.containsKey(tmp)) map.replace(tmp, map.get(tmp), map.get(tmp) + 1);
            else map.put(tmp, 1);
        }
        fileInputStream.close();
        int min = Collections.min(map.values());
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) list.add(entry.getKey());
        }
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
