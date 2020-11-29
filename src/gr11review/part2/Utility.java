package gr11review.part2;

import java.io.*;
import java.util.*;
/**
* Library of grade 11 part 2 review functions
* @author: J. Lin & S. Liu
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
  
  /**
  * Takes in a string and removes the middle letter of any 3 letter word beginning with z and ending with p
  *
  * @param strInput The given string
  * @return input string without the middle letter between any z's and p's
  * @author S.Liu
  */
  public static String zipZap(String strInput) {

    // Declare variable
    String strOutput;

    // Initialize variable 
    strOutput = "";

    // Iterate through the string and check if the letter i is 'z' and the letter i + 2 is 'p'. If so, add 'zp' to the output and increment i by 2 to skip to the letter after 'p'. If not, add character i to the output
    for (int i = 0; i < strInput.length(); i++) {
      if (i + 2 < strInput.length() && strInput.charAt(i) == 'z' && strInput.charAt(i + 2) == 'p') {
        strOutput += "zp";
        i += 2;
      }
      else {
        strOutput += strInput.charAt(i);
      }
    }

    // Return output string
    return strOutput;

  }

  /**
  * Returns the longest word in a given text file
  *
  * @param strFileName The name of the file
  * @return longest word in the file
  * @author S.Liu
  */
  public static String longestWord(String strFileName) throws IOException {

    // Create buffered reader 
    BufferedReader thefile = new BufferedReader(new FileReader(strFileName));

    // Declare variables
    String strLongestWord;
    String strCurrentWord;

    // Initialize variables 
    strLongestWord = "";
    strCurrentWord = thefile.readLine();
    
    // While the end of the given file hasn't been reached, read the new string. If the new string is as long as or longer than the current longest word, update the longest word variable
    while (strCurrentWord != null) {
      if (strCurrentWord.length() >= strLongestWord.length()) {
        strLongestWord = strCurrentWord;
      }
      strCurrentWord = thefile.readLine();
    }

    // Close file
    thefile.close();

    // Return longest word
    return strLongestWord;

  }

  /**
  * For each multiple of 10 in an integer array, every non-multiple of 10 after that is turned into that multiple of 10 until another multiple of 10 is reached
  *
  * @param intNums The integer array
  * @return the updated array
  * @author S.Liu
  */
  public static int[] tenRun(int[] intNums) {

    // Declare variables
    int intCurrentMultiple;

    // Initialize variables
    intCurrentMultiple = -1;

    // Iterate through the array. If a multiple of 10 is encountered, update the current multiple. Every non-multiple of 10 after that is changed to that current multiple
    for (int i = 0; i < intNums.length; i++) {
      if (intNums[i] % 10 == 0) {
        intCurrentMultiple = intNums[i];
      }
      else if (intNums[i] % 10 != 0 && intCurrentMultiple != -1) {
        intNums[i] = intCurrentMultiple;
      }
    }

    // Return array
    return intNums;

  }

  /**
  * Takes in two integer arrays sorted in increasing order and checks if all the numbers in the inner array appear in the outer array
  *
  * @param intOuter The outer array
  * @param intInner The inner array
  * @return if all elements in the innner array are in the outer array
  * @author S.Liu
  */
  public static boolean linearIn(int[] intOuter, int[] intInner) {

    // Declare variables
    int intOuterCounter;
    int intInnerCounter;

    // Initialize variables
    intOuterCounter = 0;

    // Iterate through each element of the inner array, looking for a match with the outer array by an incrementing the intOuterCounter varaible
    for (intInnerCounter = 0; intInnerCounter < intInner.length; intInnerCounter++) {
      while (intOuterCounter < intOuter.length) {
        // If the outer item is greater than the current inner item, that means that there's no match for the current inner item; return false
        if (intOuter[intOuterCounter] > intInner[intInnerCounter]) {
          return false;
        }
        // If the outer item is equal to the current inner item, that means a match for the current inner item has been found; break out of the while loop and move to the next inner item
        else if (intInner[intInnerCounter] == intOuter[intOuterCounter]) {
          break;
        }
        // Move to the next outer item in search of a match. If the end of the array is reached, return false
        else {
          intOuterCounter++;
          if (intOuterCounter == intOuter.length) {
            return false;
          }
        }
      } 
    }
    
    // If this part of the code is reached, every inner item has a match; return true
    return true;

  }

  /**
  * Prints pascal's triangle up to the given row i and column j
  *
  * @param i The row number
  * @param j The column number
  * @author S.Liu
  */
  public static void pascalTri(int i, int j) throws IOException {

    // Initialize print writer
    PrintWriter theout = new PrintWriter(new FileWriter("src/gr11review/part2/pascalOut.txt"), false);

    // Declare variables
    int intRowCounter;
    int intColCounter;
    int intPascalTriangle[][] = new int[i][j];

    // Set the first row and column equal to 1
    for (intRowCounter = 0; intRowCounter < i; intRowCounter++) {
      intPascalTriangle[intRowCounter][0] = 1;
    }
    for (intColCounter = 0; intColCounter < j; intColCounter++) {
      intPascalTriangle[0][intColCounter] = 1;
    }

    // Iterate the row from 1 to i-1. For each of these rows, iterate the column from 1 to j-1. The pascal's triangle value of cell[i][j] is the sum of the pascal's triangle values to its left and above
    for (intRowCounter = 1; intRowCounter < i; intRowCounter++) {
      for (intColCounter = 1; intColCounter < j; intColCounter++) {
        intPascalTriangle[intRowCounter][intColCounter] = intPascalTriangle[intRowCounter - 1][intColCounter] + intPascalTriangle[intRowCounter][intColCounter - 1];
      }
    }

    // Iterate through the 2D array and print out rows 0 to i-1 and columns 0 to j-1
    for (intRowCounter = 0; intRowCounter < i; intRowCounter++) {
      for (intColCounter = 0; intColCounter < j; intColCounter++) {
        theout.print(intPascalTriangle[intRowCounter][intColCounter]);
        if (intColCounter != j - 1) {
          theout.print(",");
        }
      }
      theout.println();
    }

    // Close file 
    theout.close();
  }

}
