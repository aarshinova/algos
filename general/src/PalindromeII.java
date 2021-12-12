class Solution {
    //drete
    // bebeb
    // abdcda
    // bebae
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