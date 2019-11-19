package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner("Иванов Иван Иванович 31 12 1950");
        PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);
        System.out.println(adapter.read());
        adapter.close();
    }
    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner scanner){
            this.fileScanner = scanner;
        }
        @Override
        public Person read() throws IOException {
            if (fileScanner.hasNext()) {
                String[] str = fileScanner.nextLine().split("\\s+");
                String data = str[3] + " " + str[4] + " " + str[5];
                Person person = null;
                try {
                    person = new Person(str[1], str[2], str[0], new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH).parse(data));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return person;
            }
            else return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }


}
