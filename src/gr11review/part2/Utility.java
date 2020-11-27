package gr11review.part2;

import java.io.*;
import java.util.*;
/**
* Library of grade 11 part 2 review functions
* @author: J. Lin
*
*/
public class Utility {

  /**
  * Takes in a string and returns the sum of the numbers within the string
  *
  * @param str The string that is being checked
  * @return sum of numbers in str
  * @author J. Lin
  */
  public static int sumNumbers(String str) {

    // Variable declaration and initialization
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
    // Returns the total
    return intTotal;

  }

  /**
  * Goes through a text file and returns the line that is first alphabetically
  *
  * @param filenametxt The name of the file we are checking
  * @return Alphabetically highest string in the file
  * @author J. Lin
  */  
  public static String alphaWord(String filenametxt) throws IOException {
    // Create bufferedreader to read file.
    BufferedReader theFile = new BufferedReader(new FileReader(filenametxt));

    // Variable initialization and declaration
    String strLine;
    String strAlpha;
    strAlpha = theFile.readLine();
    strLine = "";
    
    // Go through each line of the file
    while (strLine != null) {

      // Compare the next line with the current alphabetically highest string and replace it if the next line is alphabetically first
      strLine = theFile.readLine();
      if (strLine != null && strAlpha.compareTo(strLine) > 0) {
        strAlpha = strLine;
      }

    }
    
    // Close the file and return the string
    theFile.close();
    return strAlpha;

  }

  /**
  * Returns an array where all instances of the selected value in the array are turned into its numerically greatest neighbor
  *
  * @param nums The array we are checking
  * @param value The value we are looking for in the array
  * @return Array where the all instances of the value turn into its numerically greatest neighbor
  * @author J. Lin
  */ 
  public static int[] notAlone(int[] nums, int value) {

    // Variable initialization and declaration
    int intLength;
    intLength = nums.length;

    // Iterates through the array
    for (int intCount = 1; intCount < intLength-1; intCount++) {
      
      // If the current number equals value and doesn't equal the numbers before and after it, set the current number equal to the max of the two numbers adjacent to it
      if (nums[intCount] == value) {
        if (nums[intCount - 1] != nums[intCount] && nums[intCount + 1] != nums[intCount]) {
          nums[intCount] = Math.max(nums[intCount - 1], nums[intCount + 1]);
        }
      }

    }
    
    // Return array
    return nums;

  }
  
  /**
  * Returns whether or not an array can be split into equal sums
  *
  * @param nums The array we are checking
  * @return boolean of whether array can be split into equal sums.
  * @author J. Lin
  */ 
  public static boolean canBalance(int[] nums){

    // Variable declaration and initialization
    int intLength;
    int intSum;
    int intPreSum;
    intLength = nums.length;
    intSum = 0;
    intPreSum = 0;

    // Obtain the sum of all numbers in the array 
    for (int intCount = 0; intCount < intLength; intCount++) {

      intSum += nums[intCount];

    }

    // Iterate through the array, keeping track of the sum of all numbers up to the current index
    for (int intCount = 0; intCount < intLength; intCount++) {
      
      intPreSum += nums[intCount];
      // Return true if the array is "balanced"
      if (intSum - intPreSum == intPreSum) {
        return true;
      }
      // Return false if the current sum is already greater than the sum of all leftover numbers in the array
      else if (intPreSum > intSum - intPreSum) {
        return false;
      }

    }
    
    // Returns false as backup
    return false;

  }

  /**
  * Takes in an integer, n, and prints out a square of length n to a text file, where one half is 0's, seperated by 1's, and the other half is 2's
  *
  * @param n The length of square we should make
  * @author J. Lin
  */ 
  public static void diagonal(int n) throws IOException {
    
    // Initialize printwriter
    PrintWriter theOut = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt"));

    // Variable initialization and declaration
    int[][] intGrid = new int[n][n];

    // Go through each row of the square
    for (int intCount = 0; intCount < n; intCount++) {

      // Go through each coloumn of the row
      for (int intCount2 = 0; intCount2 < n; intCount2++) {
        // Set the value in the array to 0 if the coloumn number is less then the total number of rows minus the current row
        // Minus an extra 1 because coloumn and row number starts at 0
        if (intCount2 < n - intCount - 1) {
          intGrid[intCount][intCount2] = 0;
        }
        // Set the value in the array to 1 if the coloumn number is equal to the total number of rows minus the current row
        else if (intCount2 == n - intCount - 1) {
          intGrid[intCount][intCount2] = 1;
        }
        // Otherwise set value in array to 2
        else { 
          intGrid[intCount][intCount2] = 2;
        }

      }

    }
    // Go through each element in array and print it to the text file
    for (int intCount = 0; intCount < n; intCount++) {
      // Print out each element on the same line in the text file
      for (int intCount2 = 0; intCount2 < n; intCount2++) {
        theOut.print(intGrid[intCount][intCount2]);
        if (intCount2 != n-1) {
            theOut.print(",");
        }
      }
      // Go to next line in text file
      theOut.println();     
    }
    // Close the file
    theOut.close();

  }

}