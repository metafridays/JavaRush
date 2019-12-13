package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() {
        String big = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small = "abcdefghijklmnopqrstuvwxyz";
        String nums = "1234567890";
        char[] password = new char[8];
        int bigLetters;
        int smallLetters;
        int numbers;
        int totalLength = 8;
        byte rnd;
        rnd = random(1, totalLength - 2);
        bigLetters = rnd;
        totalLength -= rnd;
        rnd = random(1, totalLength - 1);
        smallLetters = rnd;
        numbers = 8 - smallLetters - bigLetters;
        for (int i = 0; i < bigLetters; i++) {
            while (true) {
                char letter = big.charAt(random(0, big.toCharArray().length - 1));
                rnd = random(0, 7);
                if (password[rnd] == 0) {
                    password[rnd] = letter;
                    break;
                }
            }
        }
        for (int i = 0; i < smallLetters; i++) {
            while (true) {
                char letter = small.charAt(random(0, small.toCharArray().length - 1));
                rnd = random(0, 7);
                if (password[rnd] == 0) {
                    password[rnd] = letter;
                    break;
                }
            }
        }
        for (int i = 0; i < numbers; i++) {
            while (true) {
                char letter = nums.charAt(random(0, nums.toCharArray().length - 1));
                rnd = random(0, 7);
                if (password[rnd] == 0) {
                    password[rnd] = letter;
                    break;
                }
            }
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(String.valueOf(password).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    public static byte random(int x, int y) {
        byte random;
        do {
            random = (byte)(Math.random() * 32);
        } while (random < x || random > y);
        return random;
    }
}