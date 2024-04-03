package ru.sgu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task3 {
    private int iterations;

    public Task3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число итераций: ");
        try {
            this.iterations = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        long startTime, endTime;
        startTime = System.nanoTime();
        useStringBuilder(iterations);
        endTime = System.nanoTime();
        System.out.println("Время выполнения StringBuilder: " + (endTime - startTime) + " нс");
        startTime = System.nanoTime();
        useStringBuffer(iterations);
        endTime = System.nanoTime();
        System.out.println("Время выполнения StringBuffer: " + (endTime - startTime) + " нс");
        startTime = System.nanoTime();
        useStringConcatenation(iterations);
        endTime = System.nanoTime();
        System.out.println("Время выполнения String: " + (endTime - startTime) + " нс");
    }

    private void useStringBuilder(int iterations) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, iterations).forEach(i -> stringBuilder.append(generateRandomString()));
    }

    private void useStringBuffer(int iterations) {
        StringBuffer stringBuffer = new StringBuffer();
        IntStream.range(0, iterations).forEach(i -> stringBuffer.append(generateRandomString()));
    }

    private void useStringConcatenation(int iterations) {
        String result = "";
        result = IntStream.range(0, iterations)
                .mapToObj(i -> generateRandomString())
                .collect(Collectors.joining());
    }

    private String generateRandomString() {
        return IntStream.range(0, 10)
                .mapToObj(j -> (char) ('a' + Math.random() * ('z' - 'a' + 1)))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
