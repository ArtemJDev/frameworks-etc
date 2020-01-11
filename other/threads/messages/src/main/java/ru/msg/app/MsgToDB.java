package ru.msg.app;

import ru.msg.messageSystem.Address;
import ru.msg.messageSystem.Addressee;
import ru.msg.messageSystem.Message;

public abstract class MsgToDB extends Message {
    public MsgToDB(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec(Addressee addressee) {
        if (addressee instanceof DBService) {
            exec((DBService) addressee);
        }
    }

    public abstract void exec(DBService dbService);
}
