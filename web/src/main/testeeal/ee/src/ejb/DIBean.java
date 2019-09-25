package main.testeeal.ee.src.ejb;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.xml.ws.WebServiceRef;

public class DIBean {

  @PersistenceUnit
  EntityManagerFactory entityManagerFactory;

  @PersistenceContext
  EntityManager entityManager;

  @EJB
  ExampleBean exampleBean;

  @Inject
  MyRequestScope myRequestScope;

  @Resource
  SessionContext sessionContext;

  @WebServiceRef
  MyWebServoce2  myWebServoce2;




  public String getName() {
    return "Max";
  }

}

@RequestScoped
class MyRequestScope {  }

@WebService
class MyWebServoce2 { }