package gr11review.part2;

import java.io.*;

public class Utility {

  /*
  javac -d bin src/gr11review/part2/Utility.java
  java -classpath bin gr11review.part2.Utility
  */

  // SAM
  // Function that removes the middle letter of any 3 letter word beginning with z and ending with p
  public static String zipZap(String strInput) {
    // Declare variable
    String strOutput;

    // Initialize variable appropriately
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
   

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Word: ");
    String str = br.readLine();
    while (str != "") {
      System.out.println(zipZap(str));
      System.out.print("Word: ");
      str = br.readLine();
    }
  }

}