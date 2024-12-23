package org.example.strategy;

public class EmailNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification: " + message);
    }
}


