package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader filereader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedReader file2reader = new BufferedReader((new FileReader(reader.readLine())));
            while (filereader.ready()) allLines.add(filereader.readLine());
            while (file2reader.ready()) forRemoveLines.add(file2reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        for (String st : forRemoveLines) {
            if (!allLines.contains(st)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        for (String st : forRemoveLines) allLines.remove(st);
    }
}
