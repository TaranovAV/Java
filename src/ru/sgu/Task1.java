package ru.sgu;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    private AtomicInteger incNum;
    private final int N = 100000;

    class Inc implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < N; i++) {
                incNum.incrementAndGet();
            }
        }
    }

    public Task1(int n) {
        this.incNum = new AtomicInteger(n);
    }

    public void start() {
        Thread t1 = new Thread(new Inc());
        Thread t2 = new Thread(new Inc());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Финальное значение переменной: " + this.incNum.get());
    }
}