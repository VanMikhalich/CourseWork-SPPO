package org.example.observer;


import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<Observer> observers = new ArrayList<>();
    private String publicationInfo;
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPublicationInfo(String publicationInfo) {
        this.publicationInfo = publicationInfo;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(publicationInfo);
        }
    }
}
