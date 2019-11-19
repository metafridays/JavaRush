package com.javarush.task.task20.task2002;

import javafx.scene.input.DataFormat;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("C:\\Users\\metaf\\Documents\\test1.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setBirthDate(new Date(2000, 12,24));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            user.setLastName("Lastname");
            user.setFirstName("Firstname");
            javaRush.users.add(user);
            user = new User();
            user.setBirthDate(new Date(2000, 12,24));
            user.setMale(false);
            user.setCountry(User.Country.RUSSIA);
            user.setLastName("Lastname");
            user.setFirstName("Firstname");
            javaRush.users.add(user);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) System.out.println("TRUE!");
            else System.out.println("FALSE");
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String hasUsers = users.isEmpty() ? "no" : "yes";
            printWriter.print(hasUsers + "\n");
            if (hasUsers.equals("yes")) {
                for (User user : users) {
                    printWriter.print(user.getFirstName() + "\n");
                    printWriter.print(user.getLastName() + "\n");
                    printWriter.print(user.getCountry() + "\n");
                    printWriter.print(user.isMale() ? "Male\n" : "Female\n");
                    printWriter.print(user.getBirthDate().getTime() + "\n");
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String hasUsers = reader.readLine();
            if (hasUsers.equals("yes")) {
                while (reader.ready()) {
                    User user = new User();
                    String tmp = reader.readLine();
                    user.setFirstName(tmp);
                    tmp = reader.readLine();
                    user.setLastName(tmp);
                    tmp = reader.readLine();
                    if (tmp.equals(User.Country.UKRAINE.toString())) user.setCountry(User.Country.UKRAINE);
                    if (tmp.equals(User.Country.RUSSIA.toString())) user.setCountry(User.Country.RUSSIA);
                    if (tmp.equals(User.Country.OTHER.toString())) user.setCountry(User.Country.OTHER);
                    tmp = reader.readLine();
                    if (tmp.equals("Male")) user.setMale(true);
                    if (tmp.equals("Female")) user.setMale(false);
                    tmp = reader.readLine();
                    user.setBirthDate(new Date(Long.parseLong(tmp)));
                    this.users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
