package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new TestThread1());
        threads.add(new TestThread2());
        threads.add(new TestThread3());
        threads.add(new TestThread4());
        threads.add(new TestThread5());
    }

    public static void main(String[] args) {
    }

    public static class TestThread1 extends Thread {
        @Override
        public void run() {
            super.run();
            for (;;);
        }
    }

    public static class TestThread2 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class TestThread3 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (;;) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) { }
        }
    }

    public static class TestThread4 extends Thread implements Message {
        @Override
        public void run() {
            super.run();
            try {
                for(;;) Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class TestThread5 extends Thread {
        @Override
        public void run() {
            super.run();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String tmp = "";
            int i = 0;
            try {
                while (!(tmp = reader.readLine()).equals("N")) {
                    i += Integer.parseInt(tmp);
                }
                System.out.println(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}