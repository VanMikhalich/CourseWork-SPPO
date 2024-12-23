package org.example.observer;

import org.springframework.stereotype.Repository;

@Repository
public interface Observer {
    void update(String data);
}
