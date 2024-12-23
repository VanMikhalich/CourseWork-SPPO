package org.example.observer;

import org.springframework.stereotype.Repository;


@Repository
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String data);
}
