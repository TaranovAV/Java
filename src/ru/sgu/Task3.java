package ru.sgu;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task3 {
    private static final String FILENAME = "input.txt";

    public void start() {

        int lineNumber = 0;

        try {
            Scanner scanner = new Scanner(new File(FILENAME));

            while (scanner.hasNextLine()) {
                lineNumber++;
                String[] str = scanner.nextLine().split(" ");
                if (checkInput(str, lineNumber)) {
                    System.out.println(lineNumber + ") " + str[1] + " " + str[0].charAt(0) +
                            "." + str[2].charAt(0) + ".");
                }
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Файл input.txt не найден.");
        }
    }

    private boolean checkInput(String[] str, int lineNumber) {
        if (str[0].isEmpty())  {
            System.out.println(lineNumber + ") Ошибка - пустая строка.");
            return false;
        }
        if (str.length < 3) {
            System.out.println(lineNumber + ") Ошибка - в строке меньше 3 последовательностей символов.");
            return false;
        }

        boolean error = false;
        for (int i = 0; i < 3; i++) {
            String line = str[i];
            for (int z = 0; z < line.length(); z++) {
                char c = line.charAt(z);
                if (Character.getType(c) != Character.UPPERCASE_LETTER &&
                        Character.getType(c) != Character.LOWERCASE_LETTER)
                    error = true;
            }
        }

        if (error) {
            System.out.println(lineNumber + ") Ошибка - есть постороние символы в предполагаемом ФИО.");
        }

        return !error;
    }
}
