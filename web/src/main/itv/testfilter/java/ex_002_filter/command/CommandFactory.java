package main.itv.testfilter.java.ex_002_filter.command;



import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asus on 06.02.2018.
 */
public class CommandFactory {

    private static CommandFactory factory = new CommandFactory();

    private Map<String, Command> comands = new HashMap<String, Command>();

    private CommandFactory() {

    }

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    {
        comands.put("register", new RegisterCommand());
        comands.put("login", new LoginCommand());
        comands.put("logout", new LogoutCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        Command command = comands.get(action);
        return command;
    }
}
