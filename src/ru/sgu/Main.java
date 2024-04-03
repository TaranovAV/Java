package ru.sgu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("""
                    Задание 5
                    1. Сортировка данных в файле.
                    2. Рекурсивное архивирование.
                    3. Выход.""");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число 1 или 2 для выбора задания, 3 для выхода:");
            String bl = in.next();
            in.nextLine();
            switch (bl) {
                case "1":
                    System.out.println("Введите имя файла, или нажмите Enter если имя файла - input.txt:");
                    String filename = in.nextLine().trim();
                    if (filename.isEmpty()) {
                        filename = "input.txt";
                    }
                    Task1 a = new Task1();
                    a.processFile(filename);
                    a.start();
                    break;
                case "2":
                    System.out.println("Введите название директории для архивации:");
                    String path = in.next();
                    System.out.println("Введите строку:");
                    String target = in.next();
                    new Task2(path, target).start();
                    break;
                case "3":
                    in.close();
                    return;
                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }
    }
}
