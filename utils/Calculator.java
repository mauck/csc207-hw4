/*
 * We took a look at Zhi's group's calculator code 
 * after struggling to go through the loop looking for
 * spaces and characters individually. They had the idea
 * of using the splitAt method for simplifying the string
 * into a much easier to deal with array which we implemented
 * in our own way.
 */

package edu.grinnell.csc207.mauckchi.utils;

import java.math.BigInteger;

public class Calculator
{
  /*
   * Return a BigInteger object representing the "naive"
   * calculation of the arithmetic expressions held in
   * String str, assuming numbers and operators are
   * separated by spaces.
   */
  public static BigInteger eval0(String str)
  {
    // Create array of values (removing spaces)
    String[] arr = StringUtils.splitAt(str, ' ');
    BigInteger value1 = BigInteger.valueOf(Integer.valueOf(arr[0]));
    BigInteger value2;
    // Checks for a single element array
    if (arr.length == 1)
      {
        return value1;
      } // if

    // Loops through array of numbers and operators
    for (int i = 0; i < arr.length;)
      {
        // checks the value at current position in arr
        switch (arr[i])
          {
          /* Checks the type of value.
           * If an operator: grabs the next value and computes the
           * result of applying the operator. Moves the loop to the 
           * next operation, storing the new result.
           * If a value: (first loop) moves to the next operator.
           */
            case "+":
              value2 = BigInteger.valueOf(Integer.valueOf(arr[i + 1]));
              value1 = value1.add(value2);
              i += 2;
              break;
            case "-":
              String temp = arr[i + 1];
              value2 = BigInteger.valueOf(Integer.valueOf(arr[i + 1]));
              value1 = value1.subtract(value2);
              i += 2;
              break;
            case "*":
              value2 = BigInteger.valueOf(Integer.valueOf(arr[i + 1]));
              value1 = value1.multiply(value2);
              i += 2;
              break;
            case "/":
              value2 = BigInteger.valueOf(Integer.valueOf(arr[i + 1]));
              value1 = value1.divide(value2);
              i += 2;
              break;
            case "^":
              value2 = BigInteger.valueOf(Integer.valueOf(arr[i + 1]));
              value1 = value1.pow(Integer.valueOf(arr[i + 1]));
              i += 2;
              break;
            default:
              i++;
              break;
          } // switch
      } // for
    return value1;
  } // eval0

  /*
   * Return a Fraction object representing the "naive"
   * calculation of the arithmetic expressions held in
   * String str, assuming numbers and operators are
   * separated by spaces.
   */
  public static Fraction eval1(String str)
  {
    // Create array of values (removing spaces)
    String[] arr = StringUtils.splitAt(str, ' ');
    Fraction value1 = new Fraction(arr[0]);
    Fraction value2;
    // Checks for a single element array
    if (arr.length == 1)
      {
        return value1.simplify();
      } // if

    // Loops through array of numbers and operators
    for (int i = 0; i < arr.length;)
      {
        // checks the value at current position in arr
        switch (arr[i])
          {
          /* Checks the type of value.
           * If an operator: grabs the next value and computes the
           * result of applying the operator. Moves the loop to the 
           * next operation, storing the new result in value1.
           * If a value: (first loop) moves to the next operator.
           */
            case "+":
              value2 = new Fraction(arr[i + 1]);
              value1 = value1.add(value2);
              i += 2;
              break;
            case "-":
              String temp = arr[i + 1];
              value2 = new Fraction(arr[i + 1]);
              value1 = value1.subtract(value2);
              i += 2;
              break;
            case "*":
              value2 = new Fraction(arr[i + 1]);
              value1 = value1.multiply(value2);
              i += 2;
              break;
            case "/":
              value2 = new Fraction(arr[i + 1]);
              value1 = value1.divide(value2);
              i += 2;
              break;
            case "^":
              int val2int = Integer.valueOf(arr[i + 1]);
              value1 = value1.pow(val2int);
              i += 2;
              break;
            default:
              i++;
              break;
          } // switch
      } // for 
    return value1.simplify();
  } // eval1

} // Calculator class

