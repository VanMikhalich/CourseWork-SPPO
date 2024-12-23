package org.example.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonitoringSystem implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (!observers.contains(observer)) {
            System.out.println("Observer not found");
            return;
        }
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String data) {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }

    // Метод для добавления публикации
    public void addPublication(String publication) {
        notifyObservers("New publication: " + publication);
    }
}
