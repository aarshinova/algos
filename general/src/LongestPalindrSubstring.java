
public class LongestPalindrSubstring {
    public static void main(String[] args) {
        System.out.println("Longest " + longestPalindromicSubstring("it's highnoon"));
    }

    public static String longestPalindromicSubstring(String str) {
        char[] arr = str.toCharArray();
        int count=0;
        long maxLen = 0;
        String palindromeMax = null;
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length+1; j++) {
                String subst = str.substring(i, j);
                count++;
                if (isPalindrome2(subst, count)) {
                    int len = subst.length();
                    long oldMaxLen = maxLen;
                    maxLen = Math.max(len, maxLen);
                    if (oldMaxLen != maxLen) {
                        palindromeMax = subst;
                    }
                }
            }
        }
        System.out.println("count " + count);
        return palindromeMax;
    }

    public static boolean isPalindrome(String str, int count){
        char[] arr = str.toCharArray();
        for (int i=0;i<arr.length;i++){
            char tmp = arr[i];
            arr[i] = arr[arr.length-i];
            arr[arr.length-i] = tmp;
        }
        if (str.equals(arr.toString()))
            return true;
        return false;
    }

    public static boolean isPalindrome2(String str, int count){
        int len = str.length()/2;
        char[] arr = str.toCharArray();
        for (int i = 0; i < len; i++) {
            char a = arr[i]; // 0 1 2 3 4 5 6
            char b = arr[str.length() - i - 1];
            if (a != b) {
                return false;
            }
        }

        return true;
    }
}
