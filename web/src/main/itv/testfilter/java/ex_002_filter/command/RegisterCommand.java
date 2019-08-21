package main.itv.testfilter.java.ex_002_filter.command;


import ex_002_filter.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Asus on 06.02.2018.
 */
public class RegisterCommand implements Command {

    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
        System.out.println(admin);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setAdmin(admin);
        HttpSession session = request.getSession();
        Map<String, User> usersMap = (Map<String, User>) session.getAttribute("users");
        usersMap.put(name + "_"+ password, user);
        session.setAttribute("user", user);
        return "ex_002_main.jsp";
    }

}
