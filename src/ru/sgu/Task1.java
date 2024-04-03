package ru.sgu;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Task1 {

    private static final String fileName = "output.txt";

    public ArrayList<DataFormat> data;

    public Task1() {
        this.data = new ArrayList<>();
    }

    public class DataFormat {

        private String lastName, firstName, patronymic, company, stringInf;
        int rating;

        public DataFormat(String surname, String name, String patronymic, String companyName, int rating) {
            this.lastName = surname;
            this.firstName = name == null ? "" : name;
            this.patronymic = patronymic == null ? "" : patronymic;
            this.company = companyName == null ? "" : companyName;
            this.rating = rating;
            this.stringInf = this.lastName + " " + this.firstName + " " +
                    this.patronymic + " " + this.company + " " +
                    Integer.toString(this.rating);
        }

        public int getRating() {
            return this.rating;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getPatronymic() {
            return this.patronymic;
        }

        public String getInf() {
            return this.stringInf.replaceAll("\\s+", " ");
        }

        @Override
        public int hashCode() {
            return Objects.hash(lastName, firstName, patronymic, company, rating);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            DataFormat other = (DataFormat) obj;
            return Objects.equals(lastName, other.lastName) &&
                    Objects.equals(firstName, other.firstName) &&
                    Objects.equals(patronymic, other.patronymic) &&
                    Objects.equals(company, other.company) &&
                    rating == other.rating;
        }
    }

    public void start() {
        Comparator<DataFormat> comparator = Comparator
                .comparing(DataFormat::getRating, Comparator.reverseOrder())
                .thenComparing(DataFormat::getLastName)
                .thenComparing(DataFormat::getFirstName, Comparator.reverseOrder())
                .thenComparing(DataFormat::getPatronymic);
        if (!data.isEmpty()) {
            data.sort(comparator);
            try (FileWriter writer = new FileWriter(fileName)) {
                for (DataFormat el : data) {
                    writer.write(el.getInf() + "\n");
                }
                System.out.println("Результат был успешно записан в файл " + fileName);
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }
        } else {
            System.out.println("Нет данных для обработки.");
        }
    }

    public void processFile(String fileName) {
        HashSet<DataFormat> dataSet = new HashSet<>();
        try (Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                int n = data.length;
                String surname = data[0];
                String name = (n >= 2) ? data[1] : null;
                String patronymic = (n >= 3) ? data[2] : null;
                String companyName = (n >= 4) ? data[n - 2] : null;
                int rating = Integer.parseInt(data[n - 1]);
                DataFormat el = new DataFormat(surname, name, patronymic, companyName, rating);
                dataSet.add(el);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при считывании файла `" + fileName + "`: " + e.getMessage());
        }
        data.addAll(dataSet);
    }
}
