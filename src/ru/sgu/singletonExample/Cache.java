package ru.sgu.singletonExample;

import java.util.HashMap;
import java.util.Map;

//единственная гарантированно потокобезопасная реализация синглтона
//т.к. перечисление создается единожды и сразу при старте
public enum Cache {
    INSTANCE;

    //классический вариант кэша - хеш-мапа
    private final Map<String, Track> cache = new HashMap<>();

    public void addTrack(Track track) {
        String name = track.getName();
        //если песни еще нет в кеше, добавляем
        if (!cache.containsKey(name))
            cache.put(name, track);
        System.out.println(name + " помещена в кэш");
    }
}
