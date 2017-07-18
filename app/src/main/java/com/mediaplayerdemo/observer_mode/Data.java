package com.mediaplayerdemo.observer_mode;

import java.util.ArrayList;
import java.util.List;

public class Data implements Subject {

    private List<Observer> observers = new ArrayList<>();

    public void register(Observer observer){
        observers.add(observer);
    }

    @Override
    public void update(String string) {
        for (Observer obserber:
             observers) {
            obserber.update(string);
        }
    }
}
