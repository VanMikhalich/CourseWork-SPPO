package org.example.concurrency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Request {
    private final String publication;
    private final LocalDateTime creationTime;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Request(String publication) {
        this.publication = publication;
        this.creationTime = LocalDateTime.now();
    }

    public String getCreationTime() {
        return creationTime.format(formatter);
    }

    public String getPublication() {
        return publication;
    }


    @Override
    public String toString() {
        return "Новая публикация от " + formatter.format(creationTime) + ": " + publication;
    }
}
