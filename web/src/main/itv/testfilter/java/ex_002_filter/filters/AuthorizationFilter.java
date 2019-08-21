package main.itv.testfilter.java.ex_002_filter.filters;

import ex_002_filter.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Asus on 16.05.2018.
 */
public class AuthorizationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Map<String, User> userMap = new HashMap<String, User>();
        request.setAttribute("users", userMap);

        String login = request.getParameter("name");
        String password = request.getParameter("password");


        if ( (login == null && password == null) || (login.length() > 3
                && password.length() > 5 && findExpression("[0-9]", password) ) ) {

            chain.doFilter(request, response);

        } else {
            request.getRequestDispatcher("ex_002_error.jsp").forward(request, response);
        }


    }

    private boolean findExpression(String expression, String text) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public void destroy() {

    }

}
