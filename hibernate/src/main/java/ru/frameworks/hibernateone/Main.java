package ru.frameworks.hibernateone;

import org.hibernate.Session;

public class Main {

  public static void main(String[] args) {
//    SessionFactory sessionFactory = org.hibernate.tutorials.HibernateUtil.getSessionfactory();
//    System.out.println("SUCCESS");
    Session session = HibernateUtil.getSessionfactory().openSession();
    System.out.println("SUCCESS");

  }
}
