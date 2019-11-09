package main.testeeal.ee.src.CDI;

import CDI.Interceptor.One;
import javax.enterprise.context.RequestScoped;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;

//@ApplicationScoped
////@SessionScoped
@RequestScoped
////@ConversationScoped
//@Dependent //по умолчанию, тот же реквест, только везде сетает новый экземпляр бина
@Interceptors(CDI.Interceptor.class)
@One
public class Mybean {
  int i;


}
