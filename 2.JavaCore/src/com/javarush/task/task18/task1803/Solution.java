package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            if (map.containsKey(tmp)) map.replace(tmp, map.get(tmp), map.get(tmp) + 1);
            else map.put(tmp, 1);
        }
        fileInputStream.close();
        int max = Collections.max(map.values());
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) list.add(entry.getKey());
        }
        for (Integer i : list) System.out.print(i + " ");
        reader.close();
    }
}
