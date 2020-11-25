package gr11review.test2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import gr11review.part2.Utility;


public class Review2_1Test {

    @Test
    void testSignature(){
        assertEquals("", Utility.zipZap(""));
    }
    
    @Test
    void test1(){
        assertEquals("zpzp", Utility.zipZap("zipzap"));
    }

    @Test
    void test2(){
        assertEquals("zpXzp", Utility.zipZap("zipXzap"));
    }

    @Test
    void test3(){
        assertEquals("zzzzpXzzp", Utility.zipZap("zzzzopXzzop"));
    }
    @Test
    void test4(){
        assertEquals("ziiiipzp", Utility.zipZap("ziiiipzap"));
    }

    @Test
    void test5(){
        assertEquals("xxzpxx", Utility.zipZap("xxzipxx"));
    }

}