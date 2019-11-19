package com.javarush.task.task19.task1921;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            Pattern patternName = Pattern.compile("^\\D+");
            Pattern patternDate = Pattern.compile("\\d+");
            Matcher matcherName = patternName.matcher(line);
            matcherName.find();
            String name = line.substring(matcherName.start(), matcherName.end()).trim();
            matcherName = patternDate.matcher(line);
            matcherName.find();
            int day = Integer.parseInt(line.substring(matcherName.start(), matcherName.end()));
            matcherName.find();
            int month = Integer.parseInt(line.substring(matcherName.start(), matcherName.end()));
            matcherName.find();
            int year = Integer.parseInt(line.substring(matcherName.start(), matcherName.end()));
            Date date = new Date(year - 1900, month - 1, day);
            PEOPLE.add(new Person(name, date));
        }
        bufferedReader.close();
        fileReader.close();
    }
}
