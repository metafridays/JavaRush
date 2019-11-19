package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.putIfAbsent(1.0, "first");
        labels.putIfAbsent(2.0, "second");
        labels.putIfAbsent(3.0, "third");
        labels.putIfAbsent(4.0, "fourth");
        labels.putIfAbsent(5.0, "fifth");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
