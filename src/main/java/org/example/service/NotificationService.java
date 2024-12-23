package org.example.service;

import org.example.strategy.NotificationFactory;
import org.example.strategy.NotificationStrategy;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private NotificationStrategy notificationStrategy;
    private String notificationType; // Храним текущий тип уведомления

    public void setNotificationType(String type) {
        this.notificationType = type;
        this.notificationStrategy = NotificationFactory.createNotification(type);
    }

    public void sendNotification(String message) {
        if (notificationStrategy == null) {
            throw new RuntimeException("Notification strategy not set");
        }
        notificationStrategy.sendNotification(message);
    }

    public String getNotificationType() {
        return notificationType;
    }
}
