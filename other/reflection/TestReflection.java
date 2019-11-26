package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {

  public static void main(String[] args) throws ClassNotFoundException {
    //1
    Person man = new Person();
    Class person1 = man.getClass();
    //2
    Class person2 = Person.class;
    //3
    Class person3 = Class.forName("reflection.Person");

    Method[] methods = person1.getMethods();
    for(Method method : methods) {
      System.out.println(method.getName());
      System.out.println(method.getReturnType());
      System.out.println(Arrays.toString(method.getParameterTypes()));
      System.out.println("--------");
    }

    Field[] fields = person1.getDeclaredFields();
    for(Field field : fields) {
      System.out.println(field.getName());
      System.out.println(field.getType());
      System.out.println(field.getModifiers());
      System.out.println("--------");
    }

    Annotation[] annotations = person1.getAnnotations();
    for(Annotation annotation : annotations) {
      if(annotation instanceof Author) {
        System.out.println("Yes");
      }
      System.out.println("--------");
    }
  }
}
