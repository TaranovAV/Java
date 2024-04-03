package ru.sgu;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Task3 {

    private int producers, consumers, time;

    public Task3(int prod, int cons, int tim) {
        this.producers = prod;
        this.consumers = cons;
        this.time = tim;
    }

    public void start() {
        BlockingQueue<FoodAndCalories> queue = new ArrayBlockingQueue<>(10);
        ArrayList<Thread> prod = new ArrayList<>(), cons = new ArrayList<>();
        IntStream.range(0, this.producers)
                .mapToObj(i -> new Thread(new Producers(queue, "Продюсер " + i)))
                .forEach(prod::add);
        IntStream.range(0, this.consumers)
                .mapToObj(i -> new Thread(new Consumers(queue, "Потребитель " + i)))
                .forEach(cons::add);
        ExecutorService executor = Executors.newFixedThreadPool(producers + consumers);
        prod.forEach(executor::submit);
        cons.forEach(executor::submit);
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Закрытие потоков.");
    }
}
