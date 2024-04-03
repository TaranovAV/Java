package ru.sgu;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Задание 4\s
                1) Задача с датами\s
                2) Задача с днями недели\s
                3) Задача со строкой\s
                4) Выход из программы""");

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число от 1 до 3 для выбора задания, 4 для выхода:");

        while (true) {
            System.out.println();
            if (in.hasNext()) {
                String choice = in.next();

                switch (choice) {
                    case "1":
                        Task1 task1 = new Task1();
                        task1.start();
                        break;
                    case "2":
                        System.out.println("Введите день недели и число:");
                        try (Scanner scanner = new Scanner(System.in)) {
                            String weekday = scanner.next().toLowerCase();
                            int addDays = scanner.nextInt();
                            Task2 task2 = new Task2(weekday, addDays);
                            task2.start();
                        } catch (NoSuchElementException | IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            System.exit(0);
                        }
                        break;
                    case "3":
                        Task3 task3 = new Task3();
                        task3.start();
                        return;
                    case "4":
                        System.out.println("Выход...");
                        return;
                    default:
                        System.out.println("Неверный ввод. Попробуйте снова.");
                }
            } else {
                System.out.println("Завершение программы.");
                in.close();
                return;
            }
        }
    }
}