package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

import javax.swing.plaf.TableHeaderUI;

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            //createdThreadCount++;
            this.start();
        }

        @Override
        public void run() {
            if (createdThreadCount < count) {
                System.out.println(new GenerateThread());
                //try { Thread.sleep(100); }
                //catch (InterruptedException e) { }
            }
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }
    }
}
