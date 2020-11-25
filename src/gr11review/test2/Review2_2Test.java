package gr11review.test2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import gr11review.part2.Utility;

public class Review2_2Test {

    /**
     * Test signature
     */
    @Test
    void testSignature(){
        assertTrue((Utility.sumNumbers("123") >=0 ));
    }

    /**
     * Test empty string
     */
    @Test
    void test1(){
        assertEquals(0, Utility.sumNumbers(""));
    }

     /**
      * Test non-numeric string
      */
      @Test
      void test2(){
          assertEquals(0, Utility.sumNumbers("abc"));
      }

    /**
     * Test single number in string
     */
    @Test
    void test3(){
        assertEquals(5, Utility.sumNumbers("abc5abc"));
    }

    /**
    * Test sequence of 2 digits
    */
    @Test
    void test4(){
        assertEquals(34, Utility.sumNumbers("abc34abc"));
    }

    /**
     * Test sequence greater than 2
     */
    @Test
    void test5(){
        assertEquals(7654, Utility.sumNumbers("xxxx7654xx"));
    }
  

    /** 
     * Test space betwen numbers
     */
    @Test
    void test6(){
        assertEquals(24, Utility.sumNumbers("9 8 7"));
    }

    /** 
     * Test space betwen numbers with sequences > 2
     */
    @Test
    void test7(){
        assertEquals(68, Utility.sumNumbers("10 28 30"));
    }
    

}