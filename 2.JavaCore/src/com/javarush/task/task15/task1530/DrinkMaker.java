package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {

    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    public void makeDrink() {
        this.getRightCup();
        this.putIngredient();
        this.pour();
    }
}
