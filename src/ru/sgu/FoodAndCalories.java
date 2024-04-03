package ru.sgu;

public class FoodAndCalories {
    public String name;
    public int kilocalories;

    public FoodAndCalories(String n, int c) {
        this.name = n;
        this.kilocalories = c;
    }

    public String getName() {
        return this.name;
    }

    public int getCalories() {
        return this.kilocalories;
    }
}

