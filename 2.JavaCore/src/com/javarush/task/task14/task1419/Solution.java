package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

        try {
            Integer i = null;
            i = i / 2;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> list = new ArrayList();
            Integer i = list.get(-1);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream file = new FileInputStream("test");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new IOException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new NoSuchFieldException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new NoSuchMethodException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new NoSuchElementException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new SQLException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
