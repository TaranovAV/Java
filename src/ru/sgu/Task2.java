package ru.sgu;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2 {
    private Day today;
    private Integer addDays;

    enum Day {
        monday, tuesday, wednesday, thursday, friday, saturday, sunday;

        public Day calcDay(int days) {
            int newIndex = (ordinal() + (days % values().length) + values().length) % values().length;
            return values()[newIndex];
        }
    }

    public Task2(String weekday, Integer addDays) {
        this.addDays = (addDays % 7 + 7) % 7;
        this.today = Task2.Day.valueOf(weekday);
    }

    public void start() {
        if (this.today == null || this.addDays == null) {
            System.out.println("Нет значения для текущего дня и (или) количества дней.");
            return;
        }
        System.out.println(today.calcDay(this.addDays));
    }
}
