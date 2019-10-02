package main.itv.task.flowers.src.main.java.command;

import dao.BunchDAO;
import dao.DAOFactory;
import dao.FlowerDAO;
import entitiy.Bunch;
import entitiy.Flower;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class MainCommand implements Command {

    public String execute(HttpServletRequest request) {
        DAOFactory factory = DAOFactory.getInstance();
        User user = (User) request.getSession().getAttribute("user");


            FlowerDAO flowerDAO = factory.getFlowerDAO();
            List<Flower> flowers = flowerDAO.getAll();
            request.setAttribute("flowers", flowers);


        return "main.jsp";
    }

}
