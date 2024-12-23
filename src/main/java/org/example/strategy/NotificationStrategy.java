package org.example.strategy;

import org.springframework.stereotype.Repository;

@Repository
public interface NotificationStrategy {
    void sendNotification(String message);
}
