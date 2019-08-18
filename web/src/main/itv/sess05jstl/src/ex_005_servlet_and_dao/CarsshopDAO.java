package main.itv.sess05jstl.src.ex_005_servlet_and_dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarsshopDAO {

    public List<Car> getAll() {
        Connection connection = null;
        Statement statement = null;

        List<Car> cars = new ArrayList<>();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop", "root", "root");
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT id, mark_id, model, price, (SELECT mark FROM marks WHERE id = mark_id) as mark FROM cars");

            while (rs.next()) {
                long id = rs.getLong("id");
                String model = rs.getString("model");
                int price = rs.getInt("price");
                String mark = rs.getString("mark");
                Car car = new Car();
                car.setId(id);
                car.setMark(mark);
                car.setModel(model);
                car.setPrice(price);
                cars.add(car);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && statement != null) {

                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return cars;
    }

}
