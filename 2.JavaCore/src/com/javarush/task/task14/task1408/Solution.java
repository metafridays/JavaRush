package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.RUSSIA);
        System.out.println(hen.getCountOfEggsPerMonth());
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (country == Country.RUSSIA) hen = new RussianHen();
            if (country == Country.BELARUS) hen = new BelarusianHen();
            if (country == Country.UKRAINE) hen = new UkrainianHen();
            if (country == Country.MOLDOVA) hen = new MoldovanHen();
            return hen;
        }
    }
}

abstract class Hen {
    abstract int getCountOfEggsPerMonth();
    String getDescription() {
        return "Я - курица.";
    }
}