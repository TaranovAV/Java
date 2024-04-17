package ru.sgu;


public class Main {

    public static void main(String[] args) {
        String dbname = "postgres";
        String user = "username";
        String pass = "password";
        new DataBase().run(dbname, user, pass);
    }
}