package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) {

    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
        System.out.println("");
        this.fileWriter.write(cbuf, off, len);
    }

    public void write(int c) throws IOException {
        System.out.println(c);
        this.fileWriter.write(c);
    }

    public void write(String str) throws IOException {
        System.out.println(str);
        this.fileWriter.write(str);
    }

    public void write(String str, int off, int len) throws IOException {
        char[] cbuf = str.toCharArray();
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
        this.fileWriter.write(str, off, len);
    }

    public void write(char[] cbuf) throws IOException {
        for (char c : cbuf) System.out.print(c);
        this.fileWriter.write(cbuf);
    }
}
