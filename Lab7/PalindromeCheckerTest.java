package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {
    @Test
    void PalindromeCheckerTester(){
        Assertions.assertEquals(true, PalindromeChecker.isPalindrome("lol"));
    }
    @Test
    void PalindromeCheckerTester2(){
        Assertions.assertEquals(false, PalindromeChecker.isPalindrome("SAYEED"));
    }

}