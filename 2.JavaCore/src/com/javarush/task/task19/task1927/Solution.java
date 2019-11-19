package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader (new ByteArrayInputStream(outputStream.toByteArray())));
        int timeToAdvCounter = 2;
        while (bufferedReader.ready()) {
            if (timeToAdvCounter == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
                timeToAdvCounter = 2;
            }
            else {
                timeToAdvCounter--;
                System.out.println(bufferedReader.readLine());
            }
        }
        bufferedReader.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
