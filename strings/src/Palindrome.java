import java.util.HashMap;

public class Palindrome {
    /**
     * Problem statement : https://www.interviewbit.com/problems/check-palindrome/
     *
     * @param args examples : anna, civic, radar
     *             solutions :
     *             too pointers - start from 0 and from N positions at the same time
     */
    public static void main(String[] args) {
        testIfPalindromeEven();
        testIfPalindromeOdd();
        testIfPalindromeOneMore();
        testIfPalindromeNot();
        testIfPalindromeFalsePalindrome1();
        testIfPalindromeFalsePalindrome2();
        testIfPalindromeEmpty();
    }

    private static void palindrome(String word) {
        boolean result = checkIfPalindrome(word);
        if (result) {
            System.out.println("it is palindrome");
        } else {
            System.out.println("It is not a palindrome");
        }
    }

    private static boolean checkIfPalindrome(String word) {
        if (word.length() <= 1) return false;
        char[] wordArray = word.toCharArray();
        int length = word.length();
        int half = length % 2 == 0 ? length / 2 : length - 1 / 2;
        for (int i = 0; i < half; i++) {
          char chStart = wordArray[i];
          char chEnd = wordArray[length-i-1];
          if (chStart!=chEnd) return false;
        }
        return true;
    }

    private static void testIfPalindromeEven() {
        palindrome("anna");
    }

    private static void testIfPalindromeOdd() {
        palindrome("civic");
    }

    private static void testIfPalindromeOneMore() {
        palindrome("redivider");
    }

    private static void testIfPalindromeFalsePalindrome1() {
        palindrome("ciciv");
    }

    private static void testIfPalindromeFalsePalindrome2() {
        palindrome("civci");
    }

    private static void testIfPalindromeNot() {
        palindrome("cinema");
    }

    private static void testIfPalindromeEmpty() {
        palindrome("");
    }

}
