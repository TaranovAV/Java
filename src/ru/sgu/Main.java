package ru.sgu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                    Задание 1\s
                    1) Вывод Hello World\s
                    2) Операции между двумя большими числами\s
                    3) Ввод/вывод из файла\s
                    4) Выход из программы""");

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Введите число от 1 до 3 для выбора задания, 4 для выхода:");
            String choice = in.next();

            switch (choice) {
                case "1":
                    Task1 task1 = new Task1();
                    task1.start();
                    break;
                case "2":
                    Task2 task2 = new Task2();
                    task2.start();
                    break;
                case "3":
                    Task3 task3 = new Task3();
                    task3.start();
                    break;
                case "4":
                    System.out.println("Выход...");
                    in.close();
                    return;
                default:
                    System.out.println("Неверный ввод.");
            }
        }
    }
}