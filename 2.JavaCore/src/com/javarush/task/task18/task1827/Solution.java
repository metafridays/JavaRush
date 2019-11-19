package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        char[] id;
        char[] productName;
        char[] price;
        char[] quantity;
        ArrayList<String> list = new ArrayList<>();
        if (args.length != 0 && args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   // Создаем поток чтения с консоли
            String fileName = reader.readLine();                                            // Читаем с консоли имя файла
            reader.close();                                                                 // Закрываем поток чтения с консоли
            reader = new BufferedReader(new FileReader(fileName));                          // Создаем поток чтения из файла
            while (reader.ready()) list.add(reader.readLine());                             // Читаем все строки из файла в ArrayList<String>
            reader.close();
            Integer MaxId = getMaxId(list) + 1;         // Находим максимальное значение ID в прочитанных данных и прибавляем 1
            id = MaxId.toString().toCharArray();        // Переводим полученное значение в массив char[]
            productName = args[1].toCharArray();        // Переводим значение productName в массив char[]
            price = args[2].toCharArray();              // Переводим значение price в массив char[]
            quantity = args[3].toCharArray();           // Переводим значение quantity в массив char[]
            StringBuilder stringBuilder = new StringBuilder();  // Создаем объект StringBuilder для сборки строки для записи
            stringBuilder.append("\n"); // В начало строки добавляем символ перевода строки
            stringBuilder.append(id);   // Пишем в строку ID
            // Если длина ID меньше 8 символов - добиваем в цикле пробелами до 8 символов
            if (id.length < 8) {
                for (int i = 0; i < 8 - id.length; i++) stringBuilder.append(" ");
            }
            stringBuilder.append(productName); // Пишем в строку productName
            // Если длина productName меньше 30 символов - добиваем в цикле пробелами до 30 символов
            if (productName.length < 30) {
                for (int i = 0; i < 30 - productName.length; i++) stringBuilder.append(" ");
            }
            stringBuilder.append(price);    // Пишем в строку price
            // Если длина price меньше 8 символов - добиваем в цикле пробелами до 8 символов
            if (price.length < 8) {
                for (int i = 0; i < 8 - price.length; i++) stringBuilder.append(" ");
            }
            stringBuilder.append(quantity); // Пишем в строку quantity
            // Если длина quantity меньше 4 символов - добиваем в цикле пробелами до 4 символов
            if (quantity.length < 4) {
                for (int i = 0; i < 4 - quantity.length; i++) stringBuilder.append(" ");
            }
            // Открываем поток для записи в режими дополнения
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            // Записываем в файл получившуюся строку
            writer.write(stringBuilder.toString());
            // Закрываем поток записи
            writer.close();
        }
    }

    private static int getMaxId(ArrayList<String> list) {
        int id = 0;
        for (String s : list) {
            int tmpId = Integer.parseInt(s.substring(0, 8).trim());
            if (tmpId > id) id = tmpId;
        }
        return id;
    }
}
