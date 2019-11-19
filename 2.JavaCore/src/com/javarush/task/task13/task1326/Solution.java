package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader для ввода с консоли
        StringBuilder stringBuilder = new StringBuilder();              // массив для чтения данных из файла как строки
        ArrayList<String> stringArrayList = new ArrayList<>();          // массив для копирования отдельных строк из файла
        String filename = reader.readLine();                            // чтение имени файла с консоли
        InputStream inputStream = new FileInputStream(filename);        // открываем на чтение файл
        while (inputStream.available() > 0) {
            char c = (char) inputStream.read();                         // Заполняем массив stringArrayList
            if (c != 10) stringBuilder.append(c);                       // строками из файла без
            else {                                                      // символов переносв
                stringArrayList.add(stringBuilder.toString());          //
                stringBuilder.setLength(0);                             //
            }
        }
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (String s : stringArrayList) {
            int i = Integer.valueOf(s);
            if (i % 2 == 0) {
                integerArrayList.add(i);
            }
        }
        bubbleSort(integerArrayList);
        for (int i : integerArrayList) System.out.println(i);


        reader.close();
        inputStream.close();
    }

    public static void bubbleSort(ArrayList arr) {
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for(int i = arr.size() - 1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами */
                if( (int)arr.get(j) > (int)arr.get(j+1)) {
                    int tmp = (int)arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, tmp);
                }
            }
        }

    }
}
