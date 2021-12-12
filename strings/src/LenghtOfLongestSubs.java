// Leetcode
// Given a string s, find the length of the longest substring without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//Example 4:
//
//Input: s = ""
//Output: 0

import java.util.HashSet;

class LengthOfLongestSubs {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> countChars = new HashSet<>();
        int maxLen = 0;
        int tmpCounter = 0;
        int start = 0;
        // pwwkew
        // kpwwkekghfr
        for (int i=0; i<s.length(); i++){
            if (countChars.contains(s.charAt(i))){
                countChars = new HashSet<>();
                i = findPreviousIndex(i, s.charAt(i), s);
                maxLen = Math.max(tmpCounter, maxLen);
                tmpCounter = 0;
            }else {
                countChars.add(s.charAt(i));
                tmpCounter ++ ;
            }
        }

        maxLen = Math.max(tmpCounter, maxLen);

        return maxLen;

    }

    public static int findPreviousIndex(int limit, char ch, String s) {
        int res = 0;
        for (int i=0; i<limit; i++){
            if (s.charAt(i)==ch){
                res = i;
            }
        }
        return res;
    }
}