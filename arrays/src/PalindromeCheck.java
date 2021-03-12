// Tournament winner
public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(isPalindrome("anna"));
        System.out.println(isPalindrome("snowman"));
        System.out.println(isPalindrome("abcdcba"));
        System.out.println(isPalindrome("ab"));
    }
    // snowman
    // lock
    // abcdcba


    public static boolean isPalindrome(String str) {
        int pointer1=0;
        int pointer2=0;
        int len = str.length();
        int mid = len/2;
        if (len % 2 == 0) {
            pointer1 = mid-1;
            pointer2 = mid;
        }
        else {
            pointer1 = mid-1;
            pointer2 = mid+1;
        }
        char[] arr = str.toCharArray();
        while (pointer1>=0 && pointer2<=len-1){
            if (arr[pointer1]!=arr[pointer2]){
                return false;
            }
            pointer1--;
            pointer2++;
        }

        return true;
    }
}
