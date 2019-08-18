package main.itv.sess05jstl.src.ex_007_jstl_dao;

import ex_005_servlet_and_dao.Car;
import ex_005_servlet_and_dao.CarsshopDAO;
import ex_005_servlet_and_dao.DAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class DAOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req, resp);
    }

    private void proccessRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        CarsshopDAO carsshopDAO = daoFactory.getCarsshopDAO();
        List<Car> cars = carsshopDAO.getAll();
        req.setAttribute("cars", cars);
        RequestDispatcher dispatcher = req.getRequestDispatcher("ex_007_cars.jsp");
        dispatcher.forward(req, resp);
    }

}
