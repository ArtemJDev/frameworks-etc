package ru.msg;

import ru.msg.app.DBService;
import ru.msg.app.FrontendService;
import ru.msg.app.MessageSystemContext;
import ru.msg.db.DBServiceImpl;
import ru.msg.front.FrontendServiceImpl;
import ru.msg.messageSystem.Address;
import ru.msg.messageSystem.MessageSystem;

public class MSMain {
    public static void main(String[] args) throws InterruptedException {
        MessageSystem messageSystem = new MessageSystem();

        MessageSystemContext context = new MessageSystemContext(messageSystem);
        Address frontAddress = new Address("Frontend");
        context.setFrontAddress(frontAddress);
        Address dbAddress = new Address("DB");
        context.setDbAddress(dbAddress);

        FrontendService frontendService = new FrontendServiceImpl(context, frontAddress);
        frontendService.init();

        DBService dbService = new DBServiceImpl(context, dbAddress);
        dbService.init();

        messageSystem.start();

        //for test
        frontendService.handleRequest("Ivan");
        frontendService.handleRequest("Black");

        frontendService.handleRequest("Ivan");
        frontendService.handleRequest("Black");

        Thread.sleep(1000);
        messageSystem.dispose();
    }
}
