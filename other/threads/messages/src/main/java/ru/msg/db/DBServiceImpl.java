package ru.msg.db;

import ru.msg.app.DBService;
import ru.msg.app.MessageSystemContext;
import ru.msg.messageSystem.Address;
import ru.msg.messageSystem.MessageSystem;

public class DBServiceImpl implements DBService {
    private final Address address;
    private final MessageSystemContext context;

    public DBServiceImpl(MessageSystemContext context, Address address) {
        this.context = context;
        this.address = address;
    }

    public void init() {
        context.getMessageSystem().addAddressee(this);
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public MessageSystem getMS() {
        return context.getMessageSystem();
    }

    public int getUserId(String name) {
        //todo: load id from db
        return name.hashCode();
    }
}
