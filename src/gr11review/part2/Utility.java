package gr11review.part2;

import java.io.*;
import java.util.*;

public class Utility {

  /*
  javac -d bin src/gr11review/part2/Utility.java
  java -classpath bin gr11review.part2.Utility
  */


  // SAM
  // Function that takes in a string and removes the middle letter of any 3 letter word beginning with z and ending with p
  public static String zipZap(String strInput) {
    // Declare variable
    String strOutput;

    // Initialize variable 
    strOutput = "";

    // Iterate through the string and check if the letter i is 'z' and the letter i+2 is 'p'. If so, add 'zp' to the output and increment i to skip past the 'p'. If not, add character i to the output
    for (int i = 0; i < strInput.length(); i++) {
      if (i+2 < strInput.length() && strInput.charAt(i) == 'z' && strInput.charAt(i+2) == 'p') {
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


  // SAM
  // Function that returns the longest word in a given text file
  public static String longestWord(String strFileName) throws IOException {
    // Create buffered reader tied to FileIO.txt file
    BufferedReader file = new BufferedReader(new FileReader(strFileName));

    // Declare variables
    String strLongestWord;
    String strCurrentWord;

    // Initialize variables 
    strLongestWord = "";
    strCurrentWord = file.readLine();
    
    // While the end of the given file hasn't been reached, read the new string. If the new string is as long or longer than the current longest word, update the longest word
    while (strCurrentWord != null) {
      if (strCurrentWord.length() >= strLongestWord.length()) {
        strLongestWord = strCurrentWord;
      }
      strCurrentWord = file.readLine();
    }

    // Return longest word
    return strLongestWord;
  }


  // SAM 
  // Function that takes an integer array. For each multiple of 10, every non-multiple of 10 after that is turned into that multiple of 10 until another multiple of 10 is reached
  public static int[] tenRun(int[] nums) {
    // Declare variables
    int intCurrentMultiple;

    // Initialize variables
    intCurrentMultiple = -1;

    // Iterate through the array. If we encounter a multiple of 10, update the current multiple. Every non-multiple of 10 after that is then changed to that current multiple
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 10 == 0) {
        intCurrentMultiple = nums[i];
      }
      else if (nums[i] % 10 != 0 && intCurrentMultiple != -1) {
        nums[i] = intCurrentMultiple;
      }
    }

    // Return array
    return nums;
  }


  // SAM
  // Function that takes in two integer arrays sorted in increasing order and checks if all the numbers in inner appear in outer
  public static boolean linearIn(int[] outer, int[] inner) {
    // Declare variables
    int intOuterCounter;
    int intInnerCounter;

    // Initialize variables
    intOuterCounter = 0;

    // Iterate through each element of the outer array, looking for a match with the inner array by an incrementing intInnerCounter varaible
    for (intInnerCounter = 0; intInnerCounter < inner.length; intInnerCounter++) {
      while (intOuterCounter < outer.length) {
        // If the outer item is greater than the current inner item, that means that there's no match for the current inner item; return false
        if (outer[intOuterCounter] > inner[intInnerCounter]) {
          return false;
        }
        // If the outer item is equal to the current inner item, that means a match for the current inner item has been found; exit the while loop and move to the next outer item
        // Don't increment intOuterCounter in case the next inner item is the same
        else if (inner[intInnerCounter] == outer[intOuterCounter]) {
          break;
        }
        // Move to the next outer item in search of a match. If the end of the array is reached, return false
        else {
          intOuterCounter++;
          if (intOuterCounter == outer.length) {
            return false;
          }
        }
      }
    }
    
    // If this part of the code is reached, every inner item has a match; return true
    return true;
  }
   

  public static void main(String[] args) throws IOException{
    int outer[] = {1, 1, 2, 2, 3};
    int inner[] = {1, 1, 1, 1, 4};
    
    System.out.println(linearIn(outer, inner));
  }

}