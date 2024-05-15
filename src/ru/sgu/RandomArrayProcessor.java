package ru.sgu;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomArrayProcessor {

    private int[] array;

    public RandomArrayProcessor(int size) {
        array = createRandomArray(size);
    }

    private int[] createRandomArray(int size) {
        Random random = new Random();
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = random.nextInt();
        }
        return newArray;
    }

    private int findNthElement(int[] sortedArray, int n) {
        return Arrays.stream(sortedArray)
                .skip(n)
                .findFirst().orElse(0);
    }

    private String displayArray() {
        return Arrays.toString(array);
    }

    private void process() {
        System.out.println("Массив случайных чисел:\n" + displayArray());
        Arrays.sort(array);
        System.out.println("Массив после сортировки:\n" + displayArray());

        switch (array.length) {
            case 0, 1:
                System.out.println("В массиве меньше двух элементов, невозможно определить второй по величине и третий по минимальности элементы.");
                break;
            case 2:
                int secondLargest = array[0];
                System.out.println("Второй по величине элемент: " + secondLargest +
                        "\nВ массиве только два элемента, невозможно найти третий по минимальности элемент.");
                break;
            case 3:
                int secondLargest1 = array[1];
                int thirdSmallest = array[2];
                System.out.println("Второй по величине элемент: " + secondLargest1 +
                        "\nТретий по минимальности элемент: " + thirdSmallest);
                break;
            default:
                int secondLargest2 = findNthElement(array, array.length - 2);
                int thirdSmallest1 = findNthElement(array, 2);
                System.out.println("Второй по величине элемент: " + secondLargest2 +
                        "\nТретий по минимальности элемент: " + thirdSmallest1);
                break;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите размер массива случайных чисел (n): ");
            int size = scanner.nextInt();
            if (size < 0)
                System.out.println("\nРазмер массива должен быть неотрицательным числом");
            else {
                new RandomArrayProcessor(size).process();
            }
        } catch (InputMismatchException e) {
            System.out.println("\nНекорректный ввод размера массива");
        }
    }
}
