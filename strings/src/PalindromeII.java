class Solution {
//    Leetcode :
//    Given a string s, return true if the s can be palindrome after deleting at most one character from it.
//
//
//
//            Example 1:
//
//    Input: s = "aba"
//    Output: true
//    Example 2:
//
//    Input: s = "abca"
//    Output: true
//    Explanation: You could delete the character 'c'.
//    Example 3:
//
//    Input: s = "abc"
//    Output: false
    public boolean validPalindrome(String s) {
        int pointer1 = 0;
        int pointer2 = s.length()-1;
        int maxCounter = 0;

        if (isValidPalindrome(pointer1, pointer2, s)){
            return true;
        }


        while (pointer1<pointer2) {
            if (s.charAt(pointer1) != s.charAt(pointer2)){
                String newString = s.substring(0, pointer1) + s.substring(pointer1+1);
                if (isValidPalindrome(0, newString.length()-1, newString)) {
                    return true;
                }else {
                    newString = s.substring(0, pointer2) + s.substring(pointer2+1);
                    if (isValidPalindrome(0, newString.length()-1, newString)) {
                        return true;
                    }
                }
                maxCounter++;
            }
            if (maxCounter>1){
                return false;
            }
            pointer1++;
            pointer2--;

        }

        return false;
    }


    public static boolean isValidPalindrome(int pointer1, int pointer2, String s){
        while (pointer1<pointer2){

            if (s.charAt(pointer1) != s.charAt(pointer2)){
                return false;
            }

            pointer1++;
            pointer2--;
        }

        return true;
    }
}