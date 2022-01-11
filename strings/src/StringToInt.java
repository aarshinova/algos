//Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
//
//        The algorithm for myAtoi(string s) is as follows:
//
//        Read in and ignore any leading whitespace.
//        Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
//        Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
//        Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
//        If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//        Return the integer as the final result.

public class StringToInt {

    public static void main(String[] args) {
    }

    public static int MIN = Integer.MIN_VALUE;
    public static int MAX = Integer.MAX_VALUE;

    public int myAtoi(String s) {

        char[] st = s.toCharArray();
        Boolean isNegative = false;

        int i=0;
        for (i=0; i<st.length; i++){
            if (st[i]!=' '){
                break;
            }
        }

        if (i<s.length() && st[i] == '-'){
            isNegative = true;
            i++;
        }else if (i<s.length() && st[i] == '+'){
            i++;
        }

        String res = "";
        for (int j=i;j<st.length;j++){
            if (!Character.isDigit(st[j]) && res.length()==0){
                return 0;
            }
            if (!Character.isDigit(st[j]) && res.length()>0){
                break;
            }
            if (Character.isDigit(st[j])){
                res += st[j];
            }
        }

        char[] num = res.toCharArray();
        double mult = 1;
        int result = 0;

        for (int k=num.length-1; k>=0; k--){
            mult = (k==num.length-1) ? 1 : mult*10;
            double numb =  Character.getNumericValue(num[k]) * mult;

            if (numb > MAX || numb < MIN){
                return (numb > MAX && !isNegative) ? MAX : MIN;
            }

            double sum = result + numb;
            if (sum > MAX || sum < MIN){
                return (sum > MAX  && !isNegative) ? MAX : MIN;
            }else{
                result = (int)sum;
            }

        }

        return (isNegative) ? (-1) * result : result ;


    }

}