package ru.sgu;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        System.out.println("""
                Задание 6
                1. Два потока инкрементят переменную.
                2. N-е число Фибоначчи.
                3. Потребители и продюсеры.
                4. Выход.""");
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите число от 1 до 3 для выбора подзадания, 4 для выхода:");
                String bl = in.next();
                switch (bl) {
                    case "1":
                        System.out.print("Введите число: ");
                        int num = in.nextInt();
                        Task1 task1 = new Task1(num);
                        task1.start();
                        break;
                    case "2":
                        System.out.print("Введите число n: ");
                        BigInteger numF = new BigInteger(in.next());
                        if (numF.signum() >= 0) {
                            ForkJoinPool pool = new ForkJoinPool();
                            BigInteger res = pool.invoke(new Task2(numF));
                            System.out.println(numF + "-е число Фибоначчи: " + res);
                            pool.close();
                        } else {
                            System.out.println("Число n должно быть неотрицательным");
                        }
                        break;
                    case "3":
                        System.out.print("Введите время работы очереди в секундах: ");
                        int time = in.nextInt();
                        System.out.print("Введите число производителей: ");
                        int producers = in.nextInt();
                        System.out.print("Введите число потребителей: ");
                        int consumers = in.nextInt();
                        if (producers > 0 && consumers > 0 && time > 0) {
                            Task3 third = new Task3(producers, consumers, time);
                            third.start();
                        } else {
                            System.out.println("Числа должны быть положительными.");
                        }
                        break;
                    case "4":
                        return;
                    default:
                        System.out.println("Некорректный ввод!");
                }
            }
        }
    }
}
