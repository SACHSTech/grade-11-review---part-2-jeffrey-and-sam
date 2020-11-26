package gr11review.part2;

import java.io.*;
import java.util.*;
/**
* Library of grade 11 part 2 review functions
* @author: J. Lin
*
*/
public class Utility {

  // JEFFREY
  // Takes in a string and returns the sum of the numbers within the string
  public static int sumNumbers(String str) {

    // variable declaration and initialization
    String strSum;
    int intTotal, intLength;
    char chrCharacter;
    strSum = "";
    intTotal = 0;
    intLength = str.length();

    // Go through each character in the string
    for (int intCount = 0; intCount < intLength; intCount++) {
      chrCharacter = str.charAt(intCount);
      // If the current character is a digit, add the digit to strSum
      if (Character.isDigit(chrCharacter)) {
        strSum += chrCharacter;
      }
      // Once the current character is not a string add the numeric value of strSum to intTotal and reset strSum
      else if (!strSum.equals("")) {
        intTotal += Integer.parseInt(strSum);
        strSum = "";
      }
    }
    // Checks if there was a number at the end of the string and adds it to the total
    if (!strSum.equals("")) {
      intTotal += Integer.parseInt(strSum);
    } 
  
    return intTotal;

  }

  // JEFFREY
  // Goes through a text file and returns the line that is first alphabetically
  public static String alphaWord(String filenametxt) throws IOException {

    BufferedReader theFile = new BufferedReader(new FileReader("src/gr11review/part2/" + filenametxt + ".txt"));

    String strLine;
    String strAlpha;
    strAlpha = theFile.readLine();
    strLine = "";

    while (strLine != null) {

      strLine = theFile.readLine();
      if (strLine != null && strAlpha.compareTo(strLine) > 0) {
        strAlpha = strLine;
      }

    }

    theFile.close();
    return strAlpha;

  }

  public static int[] notAlone(int[] nums, int value) {

    int intLength;
    intLength = nums.length;

    for (int intCount = 1; intCount < intLength-1; intCount++) {

      if (nums[intCount] == value) {
        if (nums[intCount-1] != nums[intCount] && nums[intCount+1] != nums[intCount]) {
          nums[intCount] = Math.max(nums[intCount-1], nums[intCount+1]);
        }
      }

    }

    return nums;

  }

  public static boolean canBalance(int[] nums){

    int intLength;
    int intSum;
    int intPreSum;
    intLength = nums.length;
    intSum = 0;
    intPreSum = 0;


    for (int intCount = 0; intCount < intLength; intCount++) {

      intSum += nums[intCount];

    }

    for (int intCount = 0; intCount < intLength; intCount++) {

      intPreSum += nums[intCount];
      if (intSum - intPreSum == intPreSum) {
        return true;
      }
      else if (intPreSum > intSum - intPreSum) {
        return false;
      }

    }

    return false;

  }

  public static void diagonal(int n) throws IOException {

    PrintWriter theOut = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt"));

    String strLine;
    strLine = "";

    for (int intCount = 1; intCount <= n; intCount++) {

      for (int intCount2 = 0; intCount2 < n - intCount; intCount2++) {
        strLine += "0, ";
      }
      strLine += "1, ";
      for (int intCount2 = 0; intCount2 < intCount - 1; intCount2++) {
        strLine += "2, ";
      }

      strLine = strLine.substring(0, strLine.length()-1);
      theOut.println(strLine);
      strLine = "";     

    }

    theOut.close();

  }

}