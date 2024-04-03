package ru.sgu;

import java.util.concurrent.BlockingQueue;


public class Consumers implements Runnable {

    private final BlockingQueue<FoodAndCalories> queue;
    private int sumKilocalories = 0;
    private String name;

    public Consumers(BlockingQueue<FoodAndCalories> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                FoodAndCalories food = queue.take();
                System.out.println(this.name + " приобрел : " + food.getName());
                sumKilocalories += food.getCalories();
                System.out.println(sumKilocalories + " килокалорий в сумме");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
