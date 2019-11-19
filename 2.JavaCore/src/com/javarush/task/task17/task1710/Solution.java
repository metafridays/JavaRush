package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args[0].equals("-i")) print(Integer.parseInt(args[1]));
        if (args[0].equals("-d")) delete(Integer.parseInt(args[1]));
        if (args[0].equals("-u")) update(Integer.parseInt(args[1]), args[2], args[3], args[4]);
        if (args[0].equals("-c")) create(args[1], args[2], args[3]);
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
        System.out.println(allPeople.size()-1);
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
