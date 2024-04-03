package ru.sgu;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.math.RoundingMode;

public class Task2 {
    public void start() {
        System.out.println("""
                Введите 2 числи и операцию через пробел\s
                Доступные операции: ADD, SUB, MULT, DIV, REM, POW\s
                """);

        Scanner in = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(-?\\d*\\.?\\d+)\\s+(-?\\d*\\.?\\d+)\\s+(ADD|SUB|MULT|DIV|REM|POW)");
        Matcher matcher = pattern.matcher(in.nextLine());

        if (matcher.matches()) {

            BigDecimal first, second;
            first = new BigDecimal(matcher.group(1));
            second = new BigDecimal(matcher.group(2));

            switch (matcher.group(3)) {
                case "ADD":
                    System.out.println("Ответ: " + first.add(second));
                    break;
                case "SUB":
                    System.out.println("Ответ: " + first.subtract(second));
                    break;
                case "MULT":
                    System.out.println("Ответ: " + first.multiply(second));
                    break;
                case "DIV":
                    System.out.println("Ответ: " + first.divide(second, RoundingMode.HALF_UP));
                    break;
                case "REM":
                    System.out.println("Ответ: " + first.remainder(second));
                    break;
                case "POW":
                    try {
                        BigInteger num = new BigInteger(matcher.group(1));
                        int deg = Integer.parseInt(matcher.group(2));
                        System.out.println("Ответ: " + num.pow(deg));
                    } catch (NumberFormatException error) {
                        System.out.println("Необходимо указать целые числа для операции POW.");
                    }
                    break;
            }
        } else {
            System.out.println("Неверный ввод!");
        }
    }
}