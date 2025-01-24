package org.example.database;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Database {
    private static Database instance;
    private final List<String> events = new ArrayList<>();

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public synchronized void saveEvent(String event) {
        events.add(event);
        log.info("Событие сохранено в базу данных: {}", event);
    }

    public void printEvents() {
        synchronized (this) {
            System.out.println("Содержимое базы данных:");
            for (String event : events) {
                System.out.println(event);
            }
        }
    }

}
