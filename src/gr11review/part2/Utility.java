package gr11review.part2;

import java.io.*;

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
   

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(longestWord("src/gr11review/part2/FileIO.txt"));
  }

}