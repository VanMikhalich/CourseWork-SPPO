package org.example.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.example.command.Command;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class Client implements Runnable {
    private final BlockingQueue<Command> queue;
    private final Command command;

    public Client(BlockingQueue<Command> queue, Command command) {
        this.queue = queue;
        this.command = command;
    }

    @Override
    public void run() {
        try {
            log.info("Клиент добавляет запрос в очередь: {}", command);
            queue.put(command);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка клиента: " + e.getMessage());
        }
    }
}
