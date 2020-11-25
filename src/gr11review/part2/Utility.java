package gr11review.part2;

import java.io.*;
import java.util.*;
//javac -d bin src/gr11review/part2/Utility.java
//java -classpath bin gr11review.part2.Utility
public class Utility {

  public static int sumNumbers(String str) {
    String strSum;
    int intTotal;
    int intLength = str.length();
    char chrCharacter;
    strSum = "";
    intTotal = 0;

    for (int intCount = 0; intCount < intLength; intCount++) {
      chrCharacter = str.charAt(intCount);

      if (Character.isDigit(chrCharacter)) {
        strSum += chrCharacter;
      } 
      else if (!strSum.equals("")) {
        intTotal += Integer.parseInt(strSum);
        strSum = "";
      }
    }
    return intTotal;

  }

  public static String alphaWord(String filenametxt) throws IOException {
    BufferedReader theFile = new BufferedReader(new FileReader("src/gr11review/part2/" + filenametxt + ".txt"));
    String strLine = "";
    String strAlpha;
    strAlpha = theFile.readLine();
    while (strLine != null) {
      strLine = theFile.readLine();
      if (strLine != null && strAlpha.compareTo(strLine) > 0) {
        strAlpha = strLine;
      }
    }
    theFile.close();
    return strAlpha;

  }



  public static void main(String[] args) throws IOException {
    System.out.println(sumNumbers("1a1a1a1"));
    System.out.println(alphaWord("file"));
  }




}