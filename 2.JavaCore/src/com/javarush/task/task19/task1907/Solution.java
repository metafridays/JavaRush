package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename); //"c:/tmp/1.txt"); //
        StringBuffer stringBuffer = new StringBuffer();

        while (fileReader.ready()) {
            stringBuffer.append((char) fileReader.read());
        }
        fileReader.close();

        Pattern p = Pattern.compile("\\b(world)\\b");
        Matcher m = p.matcher(stringBuffer);

        int cx = 0;
        while (m.find()){
            cx++;
        }
        System.out.println(cx);
    }
}
