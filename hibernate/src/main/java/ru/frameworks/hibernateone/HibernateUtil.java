package ru.frameworks.hibernateone;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
   private static SessionFactory sessionFactory = null;
  static {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
  try {
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  } catch (Exception e) {
    StandardServiceRegistryBuilder.destroy(registry);
    }
  }
   /*static {
    Configuration cfg = new Configuration().configure();
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
    try{
      sessionFactory = cfg.buildSessionFactory(builder.build());
    }catch(Exception e){
      System.out.println("Error");
    }

  }*/
  public static SessionFactory getSessionfactory() {
    return sessionFactory;
  }
}
