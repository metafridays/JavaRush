package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("name1", 5.4F, 6);
        Beach beach2 = new Beach("name2", 1.4F, 9);
        Beach beach3 = new Beach("name3", 1.4F, 1);
        System.out.println(beach2.compareTo(beach1));
        System.out.println(beach1.compareTo(beach3));
        System.out.println(beach3.compareTo(beach2));

    }

    @Override
    public synchronized int compareTo(Beach beach) {
        return (int) this.distance + this.quality*2 - (int) beach.distance - beach.quality*2;
    }
}
