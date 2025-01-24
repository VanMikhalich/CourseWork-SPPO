package org.example;

import org.example.service.MonitoringService;

public class App {
    public static void main(String[] args) {
        MonitoringService monitoringService = new MonitoringService();

        monitoringService.publishNewActivity("Новое исследование опубликовано");
        monitoringService.publishNewActivity("Добавлена статья в базу данных");
        monitoringService.publishNewActivity("Написана новая научно-исследовательская работа");
        monitoringService.publishNewActivity("Опубликована докторская диссертация");
    }
}
