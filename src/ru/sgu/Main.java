package ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public IT getIT(String name, String prod) {
        IT itd = new IT(name, prod);
        itd.hireEmployee(new Employee("Алексей", "Иванов", "Проектировщик", 85000));
        itd.hireEmployee(new Employee("Михаил", "Петров", "Главный разработчик", 130000));
        itd.hireEmployee(new Employee("Елена", "Сидорова", "Тестировщик", 95000));
        itd.hireEmployee(new Employee("Дарья", "Козлова", "Программист", 110000));
        itd.hireEmployee(new Employee("Иван", "Семенов", "Архитектор", 140000));
        itd.hireEmployee(new Employee("Ольга", "Николаева", "Начальник отдела", 200000));
        itd.hireEmployee(new Employee("Павел", "Смирнов", "Аналитик", 100000));
        itd.hireEmployee(new Employee("Андрей", "Ковалев", "Разработчик", 115000));
        return itd;
    }

    public Production getProduction(String name, String prod) {
        Production ph = new Production(name, prod);
        ph.hireEmployee(new Employee("Андрей", "Кузнецов", "Монтажник", 95000));
        ph.hireEmployee(new Employee("Светлана", "Васильева", "Техник-электронщик", 105000));
        ph.hireEmployee(new Employee("Павел", "Смирнов", "Сборщик", 85000));
        ph.hireEmployee(new Employee("Владислав", "Макаров", "Инженер", 120000));
        ph.hireEmployee(new Employee("Евгений", "Павлов", "Начальник отдела", 210000));
        ph.hireEmployee(new Employee("Олег", "Иванов", "Инженер", 100000));
        ph.hireEmployee(new Employee("Александра", "Смирнова", "Техник", 95000));
        ph.hireEmployee(new Employee("Игорь", "Петров", "Сборщик", 90000));
        ph.hireEmployee(new Employee("Екатерина", "Новикова", "Контролер качества", 105000));
        return ph;
    }

    public TechSupport getTechSupport(String name) {
        TechSupport ts = new TechSupport(name);
        ts.hireEmployee(new Employee("Алиса", "Зайцева", "Специалист по обслуживанию", 90000));
        ts.hireEmployee(new Employee("Антон", "Соколов", "Технический консультант", 100000));
        ts.hireEmployee(new Employee("Мария", "Григорьева", "Инженер поддержки", 95000));
        ts.hireEmployee(new Employee("Денис", "Федоров", "Специалист по ремонту", 110000));
        ts.hireEmployee(new Employee("Татьяна", "Иванова", "Начальник отдела", 200000));
        ts.hireEmployee(new Employee("Алексей", "Сидоров", "Технический аналитик", 100000));
        ts.hireEmployee(new Employee("Надежда", "Кузнецова", "Специалист технической поддержки", 90000));
        ts.hireEmployee(new Employee("Михаил", "Андреев", "Инженер по ремонту", 105000));
        return ts;
    }

    public void run() {
        Main m = new Main();

        Company c = new Company("ПринтерМастер");
        c.addDepartment(m.getIT("IT-отдел №1", "разработка новой линейки принтеров"));
        c.addDepartment(m.getIT("IT-отдел №2", "улучшение производства картриджей"));
        c.addDepartment(m.getProduction("Производственный цех", "высокоточные принтеры"));
        c.addDepartment(m.getTechSupport("Техническая поддержка"));
        System.out.println(c.toString());

        ArrayList<BasicInfo> deps = c.getDepartments();
        System.out.println("\nСравнение двух IT-отделов: " + deps.get(0).equals(deps.get(1)));

        System.out.println("\nХеш-коды отделов:" );
        for (BasicInfo el : deps) {
            System.out.println(el.getDepartmentName() + ": " + el.hashCode());
        }

        System.out.println("\nСравнение отделов по количеству сотрудников:");
        System.out.println("Количество сотрудников:" );
        for (BasicInfo el : deps) {
            System.out.println(el.getDepartmentName() + ": " + el.getTotalNumberOfEmployees());
        }

        System.out.println("\nСравнение IT-отделов: " + deps.get(0).compareTo(deps.get(1)));
        System.out.println("Сравнение отдела технической поддержки и IT-отдела №1: " +
                deps.get(3).compareTo(deps.get(1)));

        System.out.println("\nНазначение отделов:" );
        for (BasicInfo el : deps) {
            System.out.println(el.toString());
        }

        System.out.println("\nВыплата зарплат сотрудникам отделов:" );
        BigDecimal sum = new BigDecimal(0);
        for (BasicInfo el : deps) {
            sum = sum.add(el.getTotalSalary());
            System.out.println(el.getDepartmentName() + ": " + el.getTotalSalary());
        }
        System.out.println("Суммарная выплата: " + sum);

    }
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
