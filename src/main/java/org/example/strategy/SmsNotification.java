package org.example.strategy;

public class SmsNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS notification: " + message);
    }
}