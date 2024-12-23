package org.example.service;

import org.example.database.Database;
import org.example.observer.MonitoringSystem;
import org.example.observer.ConcreteObserver;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {
    private final Database database;
    private final MonitoringSystem monitoringSystem;

    public MonitoringService(NotificationService notificationService) {
        this.database = Database.getInstance();
        this.monitoringSystem = new MonitoringSystem();

        monitoringSystem.addObserver(new ConcreteObserver("First observer", notificationService, "email"));

        monitoringSystem.addObserver(new ConcreteObserver("Second observer", notificationService, "sms"));
    }

    public void publishNewActivity(String activity) {
        database.saveData(activity);
        monitoringSystem.addPublication(activity);
    }
}
