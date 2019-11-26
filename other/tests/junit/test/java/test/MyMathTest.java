package test;

import org.junit.Test;

public class MyMathTest {

  @Test(expected = ArithmeticException.class)
  public void zeroEnumeratorShouldThrowException() {
    MyMath.divide(1,0);
  }


}
