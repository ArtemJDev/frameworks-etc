package main.testeeal.ee.src.CDI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;
import main.testeeal.ee.src.CDI.Interceptor.One;


@One
@javax.interceptor.Interceptor
public class Interceptor {

  @InterceptorBinding
  @Target({ElementType.METHOD, ElementType.TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @interface One{}

  @AroundConstruct
  private void  aroundConstr(InvocationContext context) throws Exception {
    System.out.println("Before constructor");
    context.proceed();
  }
  @PostConstruct
  public void doJob() {
    System.out.println("Do job PostConstruct");
  }
 @AroundInvoke
  public Object doJob2(InvocationContext context) throws Exception {
    System.out.println("Do job AroundInvoke");
    return context.proceed();
  }
    @PreDestroy
  public void doJob4() {
    System.out.println("Do job PreDestroy");
  }
}
