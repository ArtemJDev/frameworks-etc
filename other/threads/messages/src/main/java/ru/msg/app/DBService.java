package ru.msg.app;

import ru.msg.messageSystem.Addressee;

public interface DBService extends Addressee {
    void init();

    int getUserId(String name);
}