package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Vector2DTest {

  private final double EPS = 1e-9;
  private Vector2D v1;

  @Before //or BeforeClass must be static
  public void createNewVector() {
    v1 = new Vector2D();
  }

  @Test
  public void newVectorShouldHaveZerLength() {
    //assertion
    Assert.assertEquals(0, v1.length(), EPS);//00000001
  }

  @Test
  public void newVectorShouldHaveZeroX() {
    Assert.assertEquals(0, v1.getX(), EPS);

  }

  @Test
  public void newVectorShouldHaveZeroY() {
    Assert.assertEquals(0, v1.getY(), EPS);
  }
}
