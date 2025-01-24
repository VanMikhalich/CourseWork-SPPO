package org.example.observer;

public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }
    @Override
    public void update(String publicationInfo) {
        System.out.println(name + " get notification: " + publicationInfo);
    }
}
