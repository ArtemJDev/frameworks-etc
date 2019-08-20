package main.itv.task.flowers.src.main.java.command;

import javax.servlet.http.HttpServletRequest;


public interface Command {

    String execute(HttpServletRequest request);

}
