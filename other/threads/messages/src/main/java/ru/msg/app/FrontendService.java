package ru.msg.app;

import ru.msg.messageSystem.Addressee;

public interface FrontendService extends Addressee {
    void init();

    void handleRequest(String login);

    void addUser(int id, String name);
}
