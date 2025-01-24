package org.example.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.example.command.Command;

import java.util.concurrent.BlockingQueue;
@Slf4j
public class Server implements Runnable {
    private final BlockingQueue<Command> queue;

    public Server(BlockingQueue<Command> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Command command = queue.take();
                log.info("Сервер обрабатывает запрос: {}", command);
                command.execute();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка сервера: {}", e.getMessage());
        }
    }
}
