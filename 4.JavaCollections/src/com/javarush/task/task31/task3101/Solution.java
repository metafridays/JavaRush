package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
/*
1. Получаем переменные из параметров, переданных в командной строке:
   args[0] - path (путь к директории, в которой нужно будет пройти по дереву файлов
   args[1] - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат
*/
        String path = args[0];
        String resultFileAbsolutePath = args[1];
/*
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(),
   и, если понадобится, FileUtils.isExist()).
 */
        File fileDestination = new File(resultFileAbsolutePath);
        if (FileUtils.isExist(fileDestination)) FileUtils.renameFile(fileDestination,
                new File(fileDestination.getParent() + "\\allFilesContent.txt"));
        else System.out.println(fileDestination.getAbsolutePath() + "\n" + "File not found");
        fileDestination = new File(fileDestination.getParent() + "\\allFilesContent.txt");
/*
3.  Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
    Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
    3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
    3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1.
         После каждого тела файла записать "\n".
    Все файлы имеют расширение txt.
    В качестве разделителя пути используй "/".
    Для создания файлов используй конструктор File(String pathname).
 */
        File source = new File(path);
        ArrayList<File> list = recursiveFileTree(source);
        Comparator<File> comparator = new Comparator<File>() {
            @Override
            public int compare(File file, File t1) {
                return file.getName().compareTo(t1.getName());
            }
        };
        list.sort(comparator);
        FileWriter fileWriter = new FileWriter(fileDestination);
        for (File file : list) {
            FileReader fileReader = new FileReader(file);
            while (fileReader.ready()) fileWriter.write(fileReader.read());
            fileReader.close();
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    static ArrayList<File> recursiveFileTree(File source) {
        ArrayList<File> fileList  = new ArrayList<>();
        for (File file : source.listFiles()) {
            if (file.isDirectory()) fileList.addAll(recursiveFileTree(file));
            else if (file.length() <= 50 && file.getName().endsWith(".txt")) fileList.add(file);
        }
        return fileList;
    }

}
