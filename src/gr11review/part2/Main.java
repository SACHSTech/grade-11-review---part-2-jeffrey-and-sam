package gr11review.part2;
import java.io.*;
import java.util.*;
/**
* 
* @author: J. Lin
*
*/
public class Main{

public static void main(String[] args) throws IOException {
    
    System.out.println(Utility.sumNumbers("12a1203b2"));
    System.out.println(Utility.alphaWord("file"));
    int[] num = {3, 2, 2, 3, 2, 0, 2};
    num = Utility.notAlone(num, 2);
    System.out.println(Arrays.toString(num));
    int[] num2 = {2, 1, 1, 1, 2, 1};
    System.out.println(Utility.canBalance(num2));
    Utility.diagonal(8);

  }


}