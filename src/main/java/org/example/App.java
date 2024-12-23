package org.example;

import org.example.config.AppConfig;
import org.example.service.MonitoringService;
import org.example.service.NotificationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            MonitoringService monitoringService = context.getBean(MonitoringService.class);
            NotificationService notificationService = context.getBean(NotificationService.class);

            notificationService.setNotificationType("email");

            monitoringService.publishNewActivity("Написана научно-исследовательская работа");

            notificationService.setNotificationType("sms");

            monitoringService.publishNewActivity("Защищена докторская диссертация");
        }
    }
}
