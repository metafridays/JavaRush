package com.javarush.task.task14.task1408;


class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 7;
    }

    @Override
    String getDescription() {
        String s = super.getDescription() + " Моя страна - " + Country.MOLDOVA + "." + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }
}