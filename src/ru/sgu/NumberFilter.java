package ru.sgu;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.function.IntPredicate;

public class NumberFilter {

    private int lowerBound, upperBound;
    private IntStream stream;
    private Scanner scanner = new Scanner(System.in);

    public NumberFilter(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean validateBounds() {
        if (lowerBound > upperBound) {
            System.out.println("Ошибка!\nНижняя граница больше верхней границы.");
            return false;
        }
        return true;
    }

    private void printFilteredNumbers(IntPredicate predicate) {
        System.out.println("Результат: ");
        String result = stream.filter(predicate)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result + "\n");
    }

    public void selectMode() {
        stream = IntStream.range(lowerBound, upperBound);
        System.out.println("""
                Выберите способ фильтрации чисел:
                1. Вывести только четные числа.
                2. Вывести только нечетные числа.
                3. Вывести числа больше заданного.
                4. Вывести числа меньше заданного.
                5. Вывести числа, кратные заданному числу."""
        );
        System.out.print("Введите номер способа: ");
        String choice = scanner.next();
        scanner.nextLine();
        switch(choice) {
            case "1":
                printFilteredNumbers(x -> x % 2 == 0);
                break;
            case "2":
                printFilteredNumbers(x -> x % 2 != 0);
                break;
            case "3":
                System.out.print("Введите число для фильтрации: ");
                int greaterThan = scanner.nextInt();
                printFilteredNumbers(x -> x > greaterThan);
                break;
            case "4":
                System.out.print("Введите число для фильтрации: ");
                int lessThan = scanner.nextInt();
                printFilteredNumbers(x -> x < lessThan);
                break;
            case "5":
                System.out.print("Введите число для фильтрации: ");
                int divisibleBy = scanner.nextInt();
                printFilteredNumbers(x -> x % divisibleBy == 0);
                break;
            default:
                System.out.println("""

                        Ошибка в выборе способа фильтрации!
                        Программа завершает выполнение...""");
                break;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Введите два числа через пробел - границы массива/потока: ");
            int lower = scanner.nextInt();
            int upper = scanner.nextInt();
            NumberFilter filter = new NumberFilter(lower, upper);
            if (filter.validateBounds()) {
                filter.selectMode();
            }
        }
        catch (Exception e) {
            System.out.println("Во время выполнения программы возникла ошибка:\n" + e.getMessage());
        }
    }
}

