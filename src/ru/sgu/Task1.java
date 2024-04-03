package ru.sgu;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    private final List<LocalDate> dates;

    public Task1() {
        dates = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите даты в формате \"год месяц день\". Чтобы прекратить ввод, введите пустую строку:");
            while (true) {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    break;
                }
                String[] parts = input.split("\\s+");
                if (parts.length != 3) {
                    System.out.println("Некорректный формат даты. Попробуйте снова.");
                    continue;
                }
                try {
                    int year = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int day = Integer.parseInt(parts[2]);
                    LocalDate date = LocalDate.of(year, month, day);
                    dates.add(date);
                } catch (DateTimeParseException | NumberFormatException e) {
                    System.out.println("Некорректная дата. Попробуйте снова.");
                }
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка ввода. Завершение программы.");
            System.exit(0);
        }
    }

    public void start() {
        if (dates.isEmpty()) {
            System.out.println("Не введены корректные даты.");
            return;
        }
        LocalDate minDate = dates.getFirst();
        LocalDate maxDate = dates.getFirst();
        for (LocalDate date : dates) {
            if (date.isBefore(minDate)) {
                minDate = date;
            }
            if (date.isAfter(maxDate)) {
                maxDate = date;
            }
        }
        System.out.println("Минимальная дата: " + minDate);
        System.out.println("Максимальная дата: " + maxDate);
        System.out.println("Число дней между минимальной и максимальной датами: " +
                ChronoUnit.DAYS.between(minDate, maxDate));
    }
}
