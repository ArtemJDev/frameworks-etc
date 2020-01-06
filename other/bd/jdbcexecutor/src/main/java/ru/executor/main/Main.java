package ru.executor.main;

import java.util.List;
import ru.executor.base.DataBaseService;
import ru.executor.base.User;
import ru.executor.connection.DataBaseServiceConnection;

/**
 * Checking
 */
public class Main {

    public static void main(String[] args) throws Exception {
        try(DataBaseService dbService = new DataBaseServiceConnection()) {

            System.out.println(dbService.getMetaData());

            dbService.prepareTables();

            dbService.addUsers("artem", "artem");
            System.out.println("UserName with id = 1: " + dbService.getUserName(1));

            List<String> names = dbService.getAllNames();
            System.out.println("All names: " + names.toString());

            List<User> users = dbService.getAllUsers();
            System.out.println("All users: " + users.toString());

            dbService.deleteTables();
        }
    }
}
