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

  public static int[] notAlone(int[] nums, int value) {
    int intLength = nums.length;
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
    intLength = nums.length;
    int intSum;
    intSum = 0;
    int intPreSum;
    intPreSum = 0;


    for (int intCount = 0; intCount < intLength; intCount++) {
      intSum += nums[intCount];
    }

    for (int intCount = 0; intCount < intLength; intCount++) {
      intPreSum += nums[intCount];
      if (intSum - intPreSum == intPreSum) {
        return true;
      }
      else if (intSum - intPreSum < intPreSum) {
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


  public static void main(String[] args) throws IOException {
    
    System.out.println(sumNumbers("1a1a1a1"));
    System.out.println(alphaWord("file"));
    int[] num = {3, 2, 3};
    num = notAlone(num, 2);
    System.out.println(num[0] + " " + num[1] + " " + num[2]);
    int[] num2 = {2, 1, 1, 2, 1};
    System.out.println(canBalance(num2));
    diagonal(7);

  }




}