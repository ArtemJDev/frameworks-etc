package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Console: reflection.Person java.lang.String setName
 * Create object class Person with empty constructor
 * Create new object class String with constructor(String s) and value equals "String Value"
 * Call method with name form console, and param in constructor classObj2
 */
public class TestReflectionCreate {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
    Scanner scanner = new Scanner(System.in);
    //Name of Class1
    Class classObject = Class.forName(scanner.next());

    //Name of Class2
    Class classObject2 = Class.forName(scanner.next());

    //Name of method
    String methodName = scanner.next();

    Method m = classObject.getMethod(methodName, classObject2);

    Object o1 = classObject.newInstance();
    Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

    m.invoke(o1, o2);
    System.out.println(o1);
    System.out.println(o2);
    /**
     * Person{id=-2, name='String value'}
     * String value
     */
  }
}
