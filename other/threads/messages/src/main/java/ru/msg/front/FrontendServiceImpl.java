package ru.msg.front;

import java.util.HashMap;
import java.util.Map;
import ru.msg.app.FrontendService;
import ru.msg.app.MessageSystemContext;
import ru.msg.db.MsgGetUserId;
import ru.msg.messageSystem.Address;
import ru.msg.messageSystem.Message;
import ru.msg.messageSystem.MessageSystem;

public class FrontendServiceImpl implements FrontendService {
    private final Address address;
    private final MessageSystemContext context;

    private final Map<Integer, String> users = new HashMap<>();

    public FrontendServiceImpl(MessageSystemContext context, Address address) {
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

    public void handleRequest(String login) {
        Message message = new MsgGetUserId(getAddress(), context.getDbAddress(), login);
        context.getMessageSystem().sendMessage(message);
    }

    public void addUser(int id, String name) {
        users.put(id, name);
        System.out.println("User: " + name + " has id: " + id);
    }

    @Override
    public MessageSystem getMS() {
        return context.getMessageSystem();
    }
}
