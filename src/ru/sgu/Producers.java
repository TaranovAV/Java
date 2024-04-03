package ru.sgu;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producers implements Runnable {

    private BlockingQueue<FoodAndCalories> queue;
    private String name;

    private static final String[] foodType = {"Пицца", "Стейк", "Салат Цезарь", "Суши", "Бургер", "Паста",
            "Суп-харчо", "Картофель фри", "Роллы", "Картошка по-домашнему", "Котлеты по-киевски", "Фруктовый салат",
            "Рыба с овощами", "Чизкейк", "Пельмени", "Омлет"};
    private static final int[] foodKilocalories = {900, 600, 400, 350, 700, 500, 250, 300, 400, 350, 550, 200, 400, 600,
            350, 200};

    public Producers(BlockingQueue<FoodAndCalories> q, String n) {
        this.queue = q;
        this.name = n;
    }

    @Override
    public void run() {
        try {
            Random rand = new Random();
            while (true) {
                int randIndex = rand.nextInt(foodType.length);
                Thread.sleep((randIndex + 1) * 500);
                FoodAndCalories f = new FoodAndCalories(foodType[randIndex], foodKilocalories[randIndex]);
                queue.put(f);
                System.out.printf("%n%s добавил %s%n", this.name, f.getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
