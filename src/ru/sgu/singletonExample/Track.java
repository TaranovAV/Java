package ru.sgu.singletonExample;

//допустим, что исполнитель + название позволяют однозначно идентифицировать песню
public class Track {
    private final String name;

    public Track(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
