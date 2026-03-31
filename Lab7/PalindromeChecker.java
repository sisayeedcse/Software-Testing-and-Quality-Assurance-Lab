package org.example;

public class PalindromeChecker {
    public static boolean isPalindrome(String str){
        String resversed = new StringBuilder(str).reverse().toString();
        return str.equals(resversed);
    }
}
