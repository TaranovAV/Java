package ru.sgu;

import java.sql.*;

public class DataBase {
    private final String[] queries;

    public DataBase() {
        queries = new String[]{
                "SELECT employeeName FROM employeesAge WHERE age > 20;",
                "SELECT departmentName, AVG(salary) AS averageSalary FROM departmentSalary GROUP BY departmentName;",
                "SELECT employeeName, departmentName, location " +
                        "FROM departmentEmployee AS table1 " +
                        "JOIN departmentLocation AS table2 " +
                        "ON table1.departmentId = table2.id;"
        };
    }

    private void executeQuery(Statement statement, String query, String message, Integer Num) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("\n" + message);
        while (resultSet.next()) {
            switch (Num) {
                case 0:
                    System.out.println(resultSet.getString("employeeName"));
                    break;
                case 1:
                    System.out.println(resultSet.getString("departmentName") + " " +
                            resultSet.getInt("averageSalary"));
                    break;
                case 2:
                    System.out.println(resultSet.getString("employeeName") + " " +
                            resultSet.getString("departmentName") + " " +
                            resultSet.getString("location"));
                    break;
                default:
                    break;
            }
        }
    }

    public void run(String dbname, String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            Statement statement = conn.createStatement();

            executeQuery(statement, queries[0], "Запрос 1: Все сотрудники, с возрастом больше 20:", 0);
            executeQuery(statement, queries[1], "Запрос 2: Средняя зарплата по каждому отделу:", 1);
            executeQuery(statement, queries[2], "Запрос 3: Сотрудник, департамент и место работы:", 2);

            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка загрузки драйвера: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("При выполнении программы произошла ошибка: " + e.getMessage());
        }
    }
}
