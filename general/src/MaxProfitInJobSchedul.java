import java.util.*;

class CountUniqueCharSubstr {
    public static void main(String[] args) {

        uniqueLetterString("ABC");
        System.out.println("LEETCODE");
    }

    public static int uniqueLetterString(String s) {

        ArrayList<String> res = new ArrayList<>();
        int count = 0;
        for (int i=0; i<s.length(); i++){
            count+=findAllSubs(s.charAt(i), s.toCharArray(), i+1, res);
            res.add(""+s.charAt(i));
        }

        return count;
    }

    public static int findAllSubs(char ch, char[] arr, int i, List<String> res){
        int[] map = new int[26];
        String st="" + ch;
        map[ch -'A'] = 1;

        int currSum = 1;
        int sum = currSum;

        for (int k=i; k < arr.length; k++){
            st += arr[k];

            int tmp = map[arr[k]-'A'];
            if(tmp==0){
                currSum++;
                map[arr[k]-'A'] = tmp + 1;
            }else if(tmp==1){
                currSum--;
                map[arr[k]-'A'] = tmp + 1;
            }
            sum += currSum;

            res.add(st);
        }

        return sum;
    }



}
