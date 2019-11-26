package annotation;

@MyAnnotation
public class Test {

  @MyAnnotation
  private String name;

  @MyAnnotation
  public Test() {

  }

  @MyAnnotation
  public void test(@MyAnnotation int value) {
    @MyAnnotation String localVar = "Hello";
  }

  public static void main(@MyAnnotation String[] args) {
  }
}
