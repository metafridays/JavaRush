package com.javarush.task.task18.task1823;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        while (!str.equals("exit")) {
            ReadThread readThread = new ReadThread(str);
            readThread.start();
            str = reader.readLine();
        }
        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private FileInputStream fis;
        private String file;
        public ReadThread(String fileName) {
            //implement constructor body
            file = fileName;
            try {
                fis = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int[] buf = new int[256];
            int maxIndex = 0;
            for (int i = 0; i < 256; i++) buf[i] = 0;
            try {
                while (fis.available() > 0) {
                    buf[fis.read()]++;
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 255; i++) {
                if (buf[maxIndex] < buf[i]) maxIndex = i;
            }
            resultMap.put(file, maxIndex);
        }
    }
}
