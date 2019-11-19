package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //??????? ???????    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //??????? ???????    id=1
    }

    public static void main(String[] args) {
        //start here - ????? ???
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        create(args[i], args[i+1], args[i+2]);
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        update(Integer.parseInt(args[i]), args[i+1], args[i+2], args[i+3]);
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(Integer.parseInt(args[i]));
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        print(Integer.parseInt(args[i]));
                    }
                    break;
                }
        }
    }

    private static void update(int id, String name, String sex, String bd) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        Person person = null;
        try {
            date = format.parse(bd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (sex.equals("м")) person = Person.createMale(name, date);
        if (sex.equals("ж")) person = Person.createFemale(name, date);
        allPeople.set(id, person);
    }

    private static void delete(int id) {
        Person person = Person.createMale(null, null);
        person.setSex(null);
        allPeople.set(id, person);
    }

    private static void create(String name, String sex, String bd) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        Person person = null;
        try {
            date = format.parse(bd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (sex.equals("м")) person = Person.createMale(name, date);
        if (sex.equals("ж")) person = Person.createFemale(name, date);
        allPeople.add(person);
    }

    private static void print(int id) {
        String tmp = "";
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dateString = format.format(allPeople.get(id).getBirthDate());
        tmp += allPeople.get(id).getName();
        if (allPeople.get(id).getSex() == Sex.MALE) tmp += " " + "м";
        if (allPeople.get(id).getSex() == Sex.FEMALE) tmp += " " + "ж";
        tmp += " " + dateString;
        System.out.println(tmp);
    }
}
