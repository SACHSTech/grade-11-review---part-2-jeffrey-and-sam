package gr11review.part2;

import java.io.*;
/**
* A library of grade 11 review functions
* @author S.Liu
*
*/
public class Utility {

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