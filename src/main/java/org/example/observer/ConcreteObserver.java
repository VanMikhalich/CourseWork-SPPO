package org.example.observer;

import org.example.service.NotificationService;

public class ConcreteObserver implements Observer {
    private final String name;
    private final NotificationService notificationService;
    private final String notificationType;

    public ConcreteObserver(String name, NotificationService notificationService, String notificationType) {
        this.name = name;
        this.notificationService = notificationService;
        this.notificationType = notificationType;
    }

    @Override
    public void update(String data) {
        if (notificationType.equals(notificationService.getNotificationType())) {
            notificationService.sendNotification(name + " received update: " + data);
        }
    }
}
