package edu.grinnell.csc207.mauckchi.utils;

import java.util.Arrays;

public class StringUtils
{
  /**
  * Takes the given string and splits its elements between the given
  * character indicator.
  */
  public static String[] splitAt(String str, char c)
  {
    String[] tempArr = new String[str.length()];
    int counter = 0;
    int index1 = 0;
    int index2 = str.indexOf(c);
    // loops through entire length of tempArr
    for (int i = 0; i < tempArr.length; i++)
      {
        // checking for the end of the string
        if (index1 == str.lastIndexOf(c) + 1)
          {
            tempArr[i] = str.substring(index1);
            counter++;
            break;
          } // if
        else
          {
            tempArr[i] = str.substring(index1, index2);
            index1 = index2 + 1;
            index2 = str.indexOf(c, index1);
          } // else
        counter++;
      } // for
    String[] resultArr = new String[counter];
    //transferring tempArr elements into resultArr
    for (int i = 0; i < resultArr.length; i++)
      {
        resultArr[i] = tempArr[i];
      } // for
    return resultArr;
  } // splitAt();

  /**
  * splitCSV splits the CSV string str into an array of its values.  
  */
  public static String[] splitCSV(String str)
  {
    String[] tempArr = new String[str.length()];
    boolean inStr = false;
    // j is used for the tempArr
    int j = 0;
    StringBuffer buffer;
    buffer = new StringBuffer();
    //Goes through the entire string
    for (int i = 0; i < str.length(); i++)
      {
        char c = str.charAt(i);
        if (c == ',' && !inStr)
          {
            // put buffer in tempArr at j and j++,
            tempArr[j] = buffer.toString();

            //move on to next element (empty old)
            j++;
            buffer.delete(0, buffer.length());
          } // if a comma separator
        else if (c == ',' && inStr)
          {
            // add to buffer
            buffer.append(c);
          } //if a comma in a string
        else if (c == '"' && inStr)
          {
            if (str.charAt(i + 1) == ',')
              {
                // move buffer to array, move to next element in array
                tempArr[j] = buffer.toString();

                j++;
                // make inStr false
                inStr = false;
                // i++
                i++;
                buffer.delete(0, buffer.length());
              } // if next character is a comma
            // put single quote in buffer
            else if (str.charAt(i + 1) == '"')
              {
                buffer.append(c);
                i++;
              } // if next character is a quote
            else
              {
                buffer.append(c);
              } // else

          } // if character is a quote and in the string
        else if (c == '"' && !inStr)
          {
            // make inStr true
            inStr = true;
          } // if character is a quote and not in string
        else
          {
            // put in buffer
            buffer.append(c);
          } //else
      } // for
    // put buffer in tempArry 
    tempArr[j] = buffer.toString();
    String[] resultArr = new String[j + 1];
    //transferring tempArr elements into resultArr
    for (int i = 0; i < j + 1; i++)
      {
        resultArr[i] = tempArr[i];
      } // for
    return resultArr;
  } // splitCSV(String)
} // class StringUtils
