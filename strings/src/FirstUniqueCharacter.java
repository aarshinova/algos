//Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//
//
public class FirstUniqueCharacter {
    public static void main(String[] args) {

    }

    class Solution {
        public int firstUniqChar(String s) {
            int[] dict = new int[26];
            char[] arr = s.toCharArray();

            for (int i=0; i<arr.length; i++){
                int pos = arr[i] - 'a';
                if (dict[pos]>0) {
                    dict[pos] *= -1;
                }else if (dict[pos]==0){
                    dict[pos] = i+1;
                }
            }

            for (int j=0; j<arr.length; j++){
                int pos = arr[j] - 'a';
                if (dict[pos] > 0) {
                    return (dict[pos]-1);
                }
            }

            return -1;
        }
    }

}
