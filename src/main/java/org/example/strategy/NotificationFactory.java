package org.example.strategy;

import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {
    public static NotificationStrategy createNotification(String type) {
        switch (type) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SmsNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type");
        }
    }
}
