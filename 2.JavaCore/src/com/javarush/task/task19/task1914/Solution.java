package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String output = outputStream.toString();
        String[] numbers = new String[2];
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(output);
        matcher.find();
        numbers[0] = output.substring(matcher.start(), matcher.end());
        matcher.find();
        numbers[1] = output.substring(matcher.start(), matcher.end());
        pattern = Pattern.compile("\\D");
        matcher = pattern.matcher(output);
        String result = "";
        while (matcher.find()) {
            if (output.substring(matcher.start(), matcher.end()).equals("+")) {
                result = output + (Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
            };
            if (output.substring(matcher.start(), matcher.end()).equals("-")) {
                result = output + (Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]));
            };
            if (output.substring(matcher.start(), matcher.end()).equals("*")) {
                result = output + (Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]));
            };
        }
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

