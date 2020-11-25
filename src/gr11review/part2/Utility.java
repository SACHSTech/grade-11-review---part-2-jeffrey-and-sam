package gr11review.part2;

import java.io.*;
//javac -d bin src/gr11review/part2/Utility.java
//java -classpath bin gr11review.part2.Utility
public class Utility {

  public static int sumNumbers(String str){
    String strSum = "";
    int intTotal = 0;
    int intLength = str.length();
    char chrCharacter;

    for(int intCount = 0; intCount < intLength; intCount++){
      chrCharacter = str.charAt(intCount);

      if(Character.isDigit(chrCharacter)){
        strSum += chrCharacter;
      }else if(!strSum.equals("")){
        intTotal += Integer.parseInt(strSum);
        strSum = "";
      }
    }
    return intTotal;

  }

  public static void main(String[] args){
    System.out.println(sumNumbers("1a1a1a1"));

  }




}