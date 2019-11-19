package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            switch (args[0]) {
                case ("-u") : {
                    update(args[1], args[2], args[3], args[4]);
                    break;
                }
                case ("-d") : {
                    delete(args[1]);
                    break;
                }
            }
        }
    }

    private static void update(String id, String productName, String price, String quantity) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) list.add(reader.readLine());
        reader.close();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if(!s.substring(0, 8).trim().equals(id)) tmp.add(s);
            else {
                StringBuilder stringBuilder = new StringBuilder();  // Создаем объект StringBuilder для сборки строки для записи
                stringBuilder.append(id);   // Пишем в строку ID
                // Если длина ID меньше 8 символов - добиваем в цикле пробелами до 8 символов
                if (id.length() < 8) {
                    for (int j = 0; j < 8 - id.length(); j++) stringBuilder.append(" ");
                }
                stringBuilder.append(productName); // Пишем в строку productName
                // Если длина productName меньше 30 символов - добиваем в цикле пробелами до 30 символов
                if (productName.length() < 30) {
                    for (int j = 0; j < 30 - productName.length(); j++) stringBuilder.append(" ");
                }
                stringBuilder.append(price);    // Пишем в строку price
                // Если длина price меньше 8 символов - добиваем в цикле пробелами до 8 символов
                if (price.length() < 8) {
                    for (int j = 0; j < 8 - price.length(); j++) stringBuilder.append(" ");
                }
                stringBuilder.append(quantity); // Пишем в строку quantity
                // Если длина quantity меньше 4 символов - добиваем в цикле пробелами до 4 символов
                if (quantity.length() < 4) {
                    for (int j = 0; j < 4 - quantity.length(); j++) stringBuilder.append(" ");
                }
                tmp.add(i, stringBuilder.toString());
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String s : tmp) {
            writer.write(s + "\n");
        }
        writer.close();
    }

    private static void delete(String id) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) list.add(reader.readLine());
        reader.close();
        for (String s : list) {
            if(!s.substring(0, 8).trim().equals(id)) tmp.add(s);
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String s : tmp) {
            writer.write(s + "\n");
        }
        writer.close();
    }
}
