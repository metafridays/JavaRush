package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fis.close();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < buf.length + 1; i++) {
            if (i != buf.length && (char)buf[i] != ' ') stringBuilder.append((char)buf[i]);
            else {
                float f = Float.parseFloat(stringBuilder.toString());
                Integer tmp = Math.round(f);
                String str = tmp.toString();
                fos.write(str.getBytes());
                fos.write(' ');
                stringBuilder = new StringBuilder();
            }
        }
        fos.close();
    }
}
