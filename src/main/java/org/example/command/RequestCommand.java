package org.example.command;

import lombok.extern.slf4j.Slf4j;
import org.example.concurrency.Request;
import org.example.database.Database;
import org.example.observer.Subject;

@Slf4j
public class RequestCommand implements Command {
    private final Request request;
    private final Database database;
    private final Subject subject;

    public RequestCommand(Request request, Database database, Subject subject) {
        this.request = request;
        this.database = database;
        this.subject = subject;
    }

    @Override
    public void execute() {
        database.saveEvent(request.getPublication());
        subject.setPublicationInfo(request.toString());
    }

    @Override
    public String toString() {
        return request.toString();
    }
}
