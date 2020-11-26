package gr11review.part2;
import java.io.*;

public class Main{

public static void main(String[] args) throws IOException {
    
    System.out.println(Utility.sumNumbers("1a1a1a1"));
    System.out.println(Utility.alphaWord("file"));
    int[] num = {3, 2, 3};
    num = Utility.notAlone(num, 2);
    System.out.println(num[0] + " " + num[1] + " " + num[2]);
    int[] num2 = {2, 1, 1, 2, 1};
    System.out.println(Utility.canBalance(num2));
    Utility.diagonal(7);

  }


}