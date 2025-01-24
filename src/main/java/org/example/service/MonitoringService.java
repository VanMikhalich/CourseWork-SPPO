package org.example.service;

import org.example.command.Command;
import org.example.command.RequestCommand;
import org.example.concurrency.Client;
import org.example.concurrency.Request;
import org.example.concurrency.Server;
import org.example.database.Database;
import org.example.observer.ConcreteObserver;
import org.example.observer.Observer;
import org.example.observer.Subject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class MonitoringService {

    private final BlockingQueue<Command> queue;
    private final Server server;
    private final Subject subject;
    private final Database database;

    public MonitoringService() {
        this.queue = new LinkedBlockingQueue<>();
        this.subject = new Subject();
        this.database = Database.getInstance();

        Observer observer = new ConcreteObserver("Observer one");
        subject.addObserver(observer);

        this.server = new Server(queue);
        new Thread(server).start();
    }

    public void publishNewActivity(String activity) {
        Request request = new Request(activity);
        RequestCommand command = new RequestCommand(request, database, subject);
        Client client = new Client(queue, command);
        new Thread(client).start();
    }

}


