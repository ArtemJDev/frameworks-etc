package ru.training.spring.speed;

import java.util.Map;
import java.util.Set;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLogger {

  @Pointcut("execution(* *(..)) && within(ru.javabegin.training.spring.speed.*)")
  private void allMethods() {

  }
  //watchTime для тех которые помечены определенногй аннотацией
  @Around("allMethods() && @annotation(ru.javabegin.training.spring.speed.ShowTime) ")
 public Object watchTime(ProceedingJoinPoint joinPoint) {
   long start = System.currentTimeMillis();
   System.out.println("method begin: " + joinPoint.getSignature().toShortString());
   Object output= null;

   for(Object object : joinPoint.getArgs()) {
     System.out.println("Param : " + object);
   }

   try {
     output = joinPoint.proceed();
   } catch (Throwable throwable) {
     throwable.printStackTrace();
   }
   long time = System.currentTimeMillis() - start;
   System.out.println("method end: " + joinPoint.getSignature().toShortString() + ", time =" + time + " ms");
   return output;
 }


@AfterReturning(pointcut = "allMethods() && @annotation(ru.javabegin.training.spring.speed.ShowResult)" ,returning = "obj")
 public void print(Object obj) {
   System.out.println("Print info begin >>");

   if(obj instanceof Set) {
     Set set = (Set)obj;
     for(Object o : set) {
       System.out.println(o);
     }
   }else if(obj instanceof Map) {
     Map map = (Map) obj;
     for(Object object : map.keySet()) {
       System.out.println("key=" + object + ", " + map.get(object));
     }
   }
   System.out.println("Print info end<<");
   System.out.println();
 }
}
