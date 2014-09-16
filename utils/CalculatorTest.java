package edu.grinnell.csc207.mauckchi.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest
{

  @Test
  public void testEval0()
  {
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
    assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
    assertEquals(BigInteger.valueOf(0), Calculator.eval0("1 / 2"));
    assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
    assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 - -1"));
    assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
    assertEquals(BigInteger.valueOf(8), Calculator.eval0("2 ^ 3"));

  }
  @Test
  public void testEval1()
  {
    assertEquals(new Fraction("0"), Calculator.eval1("0"));
    assertEquals(new Fraction("1"), Calculator.eval1("1 * 1"));
    assertEquals(new Fraction("2"), Calculator.eval1("1 + 2 - 1"));
    assertEquals(new Fraction("9"), Calculator.eval1("1 + 2 * 3"));
    Fraction a = new Fraction("0/1");
    Fraction b = new Fraction("2/1");
    Fraction c = new Fraction("4");
    Fraction d = new Fraction("9/4");
    if (!a.equals(Calculator.eval1("0/4")))
      {
        System.out.println("failed1");
      }
    if (!b.equals(Calculator.eval1("3/2 + 1/2")))
      {
        System.out.println("failed2");
      }
    if (!c.equals(Calculator.eval1("1 + -2 + 10/2")))
      {
        System.out.println("failed3");
      }
    if (!d.equals(Calculator.eval1("3/4 * 2 + 3/4")))
      {
        System.out.println("failed4");
      }
  }
  
}
