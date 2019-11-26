package test;

import org.junit.Assert;
import org.junit.Test;

public class Vector2DTest {

  @Test
  public void newVectorShouldHaveZerLength() {
    Vector2D vector2D = new Vector2D();
    //assertion
    Assert.assertEquals(0, vector2D.length(), 1e-9);//00000001
  }

  @Test
  public void newVectorShouldHaveZeroX() {
    Vector2D vector2D = new Vector2D();
    Assert.assertEquals(0,vector2D.getX(), 1e-9);

  }

  @Test
  public void newVectorShouldHaveZeroY() {
    Vector2D vector2D = new Vector2D();
  Assert.assertEquals(0,vector2D.getY(), 1e-9);
  }



}
