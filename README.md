# Grade 11 Java Review Part 2

## Instructions
Program the solutions for each problem in their respective files found in the `src/gr11review/part2 directory`.  You are required to:
* with a partner, each of your coding to your own branch, code your solutions in repl.it
* commit and push changes to appropriate development branches in github.
* merge tested and completed solutions to the main branch.
* use proper style conventions for variable names and comments.


## Part 2
For all of the programs below, create a `Utility.java` file that will contain all of your methods. You can test your utility library by making calls to the methods from the Main.java file.

### Methods 1
Create a method that for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".   
**Signature** `public static String zipZap(String str)`

#### Examples
```
zipZap("zipXzap") → "zpXzp"
zipZap("zopzop") → "zpzp"
zipZap("zzzopzop") → "zzzpzp"
zipZap("zzzuzoz") → "zzzuzoz"
```

### Methods 2
Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
**Signature** `public static int sumNumbers(String str)`

#### Examples
```
sumNumbers("abc123xyz") → 123
sumNumbers("aa11b33") → 44
sumNumbers("7 11") → 18
```

### File IO - Read 1
Write a method `longestWord(String filenametxt)` such that given the name of a file `filenametxt` that contains a single word on each line,  returns the longest word in the file.  
**Signature** `public static String longestWord(String filenametxt)`

#### Example
words.txt contains:  
```
Lorem
ipsum
dolor
sit
amet
consectetur
adipiscing 
elit
```
`longestWord("words.txt")` --> `"consectetur"`

### File IO - Read 2
Write a method `alphaWord(String filenametxt)` such that given the name of a file `filenametxt` that contains a single word on each line,  returns the word that is alphabetically first.  
**Signature** `public static String alphaWord(String filenametxt)`

#### Example
words.txt contains:  
```
Lorem
ipsum
dolor
sit
amet
consectetur
adipiscing 
elit
```
`alphaWord("words.txt")` --> `"amet"`


### Array 1 - One Dimensional
For each multiple of 10 in the given array, change all the values following it to be that multiple of 10, until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.  
**Signature** `public int[] tenRun(int[] nums)`

#### Examples
```
tenRun([2, 10, 3, 4, 20, 5]) → [2, 10, 10, 10, 20, 20]
tenRun([10, 1, 20, 2]) → [10, 10, 20, 20]
tenRun([10, 1, 9, 20]) → [10, 10, 10, 20]
```

### Array 2 - One Dimensional
We'll say that an element in an array is "alone" if there are values before and after it, and those values are different from it. Return a version of the given array where every instance of the given value which is alone is replaced by whichever value to its left or right is larger.
public int[] notAlone(int[] nums, int val)  
**Signature** `public int[] notAlone(int[] nums, int value)`

#### Examples
```
notAlone([1, 2, 3], 2) → [1, 3, 3]
notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 2]
notAlone([3, 4], 3) → [3, 4]
```


### Array 3 - One Dimensional - Two Loops
Given two arrays of ints sorted in increasing order, `outer` and `inner`, return true if all of the numbers in `inner` appear in `outer`. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.  
**Signature** `public boolean linearIn(int[] outer, int[] inner)`

#### Examples
```
linearIn([1, 2, 4, 6], [2, 4]) → true
linearIn([1, 2, 4, 6], [2, 3, 4]) → false
linearIn([1, 2, 4, 4, 6], [2, 4]) → true
```


### Array 4 - One Dimensional - Two Loops
Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.  
**Signature**  `public boolean canBalance(int[] nums)`

#### Examples
```
canBalance([1, 1, 1, 2, 1]) → true
canBalance([2, 1, 1, 2, 1]) → false
canBalance([10, 10]) → true
```


### Array 5 - Two Dimensional
![pascal](/pascal.png)

* The first row are the numbers in p[0][0], p[0][1], p[0][2],..., p[0][9]
* The familiar Pascal triangle is the triangle of numbers with p[0][0] as vertex and the set of numbers p[0][9], p[1][8], p[2][7], p[3][6], ..., p[9][0] as base.
* Note that p[0][y] is always 1, and that any other number is obtained by adding two of its neighbours: the one above and the one to its left.
The number 15 for example is 5+10 (or 10+5, depending on which 15 you found)

Write a method `pascalTri(int i, int j)`  that outputs to a text file `pascalOut.txt`, a comma separted table containing `i` rows and `j` columns of pascal's triangle.  Be sure to use two-dimensional array in your solution.  
**Signature** `public static void pascalTri(int i, int j)`

#### Example
`pascalTri(3, 4)` outputs to pascalOut.txt:  
```
1,1,1,1  
1,2,3,4  
1,3,6,10
```  

`pascalTri(4, 5)` outputs to pascalOut.txt:  
```
1,1,1,1,1  
1,2,3,4,5  
1,3,6,10,15  
1,4,10,20,35
```


### Array 6 - Two Dimensional 
Given an integer n, write a method `diagonal(int n)` that outputs to a text file `diagonalOut.txt`, a two-dimensional array of size (n×n) populated as follows, with a comma between each number:  
* The positions on the minor diagonal (from the upper right to the lower left corner) receive 1 .
* The positions above this diagonal receive 0 .
* The positions below the diagonal receive 2 .  
**Signature** `public static void diagonal(int n)`  

#### Example
`diagonal(3)`  outputs to `diagonalOut.txt`:
```
0,0,1
0,1,2
1,2,2
```

`diagonal(8)`  outputs to `diagonalOut.txt`:
```
0,0,0,0,0,0,0,1
0,0,0,0,0,0,1,2
0,0,0,0,0,1,2,2
0,0,0,0,1,2,2,2
0,0,0,1,2,2,2,2
0,0,1,2,2,2,2,2
```
