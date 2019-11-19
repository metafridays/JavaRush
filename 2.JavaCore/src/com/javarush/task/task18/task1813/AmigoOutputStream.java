package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream wrappee;

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(FileOutputStream wrappee) throws FileNotFoundException {
        super("null");
        this.wrappee = wrappee;
    }

    @Override
    public void write(byte[] b) throws IOException {
        wrappee.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        wrappee.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        wrappee.write(b);
    }

    @Override
    public void flush() throws IOException {
        wrappee.flush();
    }

    @Override
    public void close() throws IOException {
        this.flush();
        byte[] bt = "JavaRush © All rights reserved.".getBytes();
        this.write(bt);
        wrappee.close();
    }
}
