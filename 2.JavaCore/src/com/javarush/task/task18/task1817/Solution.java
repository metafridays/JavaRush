package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fio = new FileInputStream(args[0]);
        int spaceCounter = 0;
        int symbolCounter = 0;
        while (fio.available() > 0) {
            if ((char)fio.read() == ' ') {
                spaceCounter++;
                symbolCounter++;
            }
            else symbolCounter++;
        }
        fio.close();
        //System.out.println(spaceCounter + " " + symbolCounter);
        System.out.printf("%.2f", (float)spaceCounter / (float)symbolCounter * 100);

    }
}
