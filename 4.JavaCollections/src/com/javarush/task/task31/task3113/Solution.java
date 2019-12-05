package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    static long totalDirs = 0;
    static long totalFiles = 0;
    static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        String dirName = reader.readLine();
        reader.close();
        Path path = Paths.get(dirName);
        do {
            if (!Files.isDirectory(path)) {
            System.out.println(dirName + " - не папка");
            break;
            }
            Files.walkFileTree(path, solution);
            System.out.println("Всего папок - " + (totalDirs-1));
            System.out.println("Всего файлов - " + totalFiles);
            System.out.println("Общий размер - " + totalSize);
        } while (false);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        //System.out.println(file.toString());
        if (Files.isRegularFile(file)) {
            Solution.totalFiles++;
            Solution.totalSize += Files.size(file);
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory(dir)) {
            Solution.totalDirs++;
        }
        return super.preVisitDirectory(dir, attrs);
    }
}