package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("C:\\Users\\metaf\\Documents\\test", ".tmp");
            OutputStream outputStream = new FileOutputStream("C:\\Users\\metaf\\Documents\\test.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\metaf\\Documents\\test.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            Human ivanov1 = new Human("Ivanov2", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            System.out.println(ivanov.equals(ivanov1));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String hasName = this.name != null ? "yes" : "no";
            printWriter.print(hasName + "\n");
            if (hasName.equals("yes")) printWriter.println(this.name);
            String hasAssets = this.assets != null && this.assets.size() > 0 ? "yes" : "no";
            printWriter.println(hasAssets);
            if (hasAssets.equals("yes")) {
                for (Asset current : this.assets) {
                    printWriter.print(current.getName() + "\n");
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String hasName = reader.readLine();
            if (hasName.equals("yes")) this.name = reader.readLine();
            String hasAssets = reader.readLine();
            String tmps;
            Asset asset;
            if (hasAssets.equals("yes")) {
                while (reader.ready()) {
                    tmps = reader.readLine();
                    if (!tmps.equals("")) {
                        asset = new Asset(tmps);
                        this.assets.add(asset);
                    }
                }
            }
            reader.close();
        }
    }
}
