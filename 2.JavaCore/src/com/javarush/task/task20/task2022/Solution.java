package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("C:\\Users\\metaf\\Documents\\test3.txt");
        solution.writeObject("Test String");
        solution.close();
        FileOutputStream fos = new FileOutputStream("C:\\Users\\metaf\\Documents\\test4.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(solution);
        os.flush();
        os.close();
        FileInputStream fis = new FileInputStream("C:\\Users\\metaf\\Documents\\test4.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        Solution solution1 = (Solution) is.readObject();
        solution1.writeObject("TestString2");
    }
}
