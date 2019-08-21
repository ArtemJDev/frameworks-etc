package main.itv.testfilter.java.ex_002_filter.command;


import ex_002_filter.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Asus on 06.02.2018.
 */
public class LoginCommand implements Command {

    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Map<String, User> userMap = (Map<String, User>) session.getAttribute("users");
        User user = userMap.get(name + "_" + password);
        session.setAttribute("user", user);
        return "ex_002_main.jsp";
    }

}
