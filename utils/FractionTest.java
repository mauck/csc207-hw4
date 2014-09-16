package edu.grinnell.csc207.mauckchi.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest
{

  @Test
  public void testNegate()
  {
    Fraction a = new Fraction (2, 3);
    assertEquals("-2/3" , a.negate().toString());
    Fraction b = new Fraction (-2, 3);
    assertEquals("2/3" , b.negate().toString());
  }

  @Test
  public void testMultiply()
  {
    Fraction a = new Fraction (2, 3);
    Fraction b = new Fraction (2, 1);
    assertEquals("4/3" , a.multiply(b).toString());
  }

  @Test
  public void testSubtract()
  {
    Fraction a = new Fraction (5, 7);
    Fraction b = new Fraction (2, 7);
    assertEquals("3/7" , a.subtract(b).toString());
    Fraction c = new Fraction (1, 4);
    Fraction d = new Fraction (1, 8);
    assertEquals("1/8" , c.subtract(d).toString());
    assertEquals("0", c.subtract(c).toString());
    assertEquals("1", c.subtract(c).denom.toString());
  }

  @Test
  public void testDivide()
  {
    Fraction a = new Fraction (2, 3);
    Fraction b = new Fraction (2, 1);
    assertEquals("1/3" , a.divide(b).toString());
  }

  @Test
  public void testPow()
  {
    Fraction a = new Fraction (1, 4);
    assertEquals("1/16" , a.pow(2).toString());
    assertEquals("1/1" , a.pow(0).toString());
    assertEquals("1/4" , a.pow(1).toString());
    assertEquals("4/1" , a.pow(-1).toString());
  }
  
  @Test
  public void testSimplify()
  {
    Fraction a = new Fraction (1, 4);
    Fraction b = new Fraction (-1, 4);
    Fraction c = new Fraction (2, 4);
    Fraction d = new Fraction (0, 4);
    assertEquals("-1/1" , a.divide(b).toString());
    assertEquals("1/2" , c.simplify().toString());
    assertEquals("0" , d.simplify().toString());
    assertEquals("1", d.simplify().denom.toString());
  }

}
