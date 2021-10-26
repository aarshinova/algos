import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class PhoneMnemonics {
    public static HashMap<String, ArrayList<String>> dict = new HashMap<>();

    public static void main(String[] args) {
        dict.put("0", new ArrayList<>(Arrays.asList("0")));
        dict.put("1", new ArrayList<>(Arrays.asList("1")));
        dict.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        dict.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        dict.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        dict.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        dict.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        dict.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        dict.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        dict.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        String phoneNumber = "234";
        ArrayList<String> actual = phoneNumberMnemonics(phoneNumber);
        System.out.println("Result " + actual);
    }

    // 2 3 4
    public static ArrayList<String> phoneNumberMnemonics(String phonenumber) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> tmpRes = new ArrayList<>();
        String ch1 = phonenumber.substring(0, 1);
        ArrayList<String> subset1 = dict.get(ch1);
        res.addAll(generateMnemonics(0, 1, phonenumber, "", tmpRes));
//        for (String val : subset1) {
//            // a
//            generateMnemonics(1, 2, phonenumber, val, tmpRes);
//            res.addAll(tmpRes);
//        }
        return res;
    }
// 234
    private static ArrayList<String> generateMnemonics(int i, int j, String phonenumber, String currRes, ArrayList<String> arr) {
        if (i >= phonenumber.length()) {
            // a d g
            arr.add(currRes);
            return arr;
        }
        // 3  4
        String nextCar = phonenumber.substring(i,j);
        // d e f  // g h i
        ArrayList<String> subset = dict.get(nextCar);
        i++;
        j++;
        for (String val : subset) {
            // a, d  // a, d , g // a,d, h
            currRes += val;
            generateMnemonics(i, j, phonenumber, currRes, arr);
//            // a, d
            int len = currRes.length();
            currRes = currRes.substring(0, len-1);
        }

        return arr;
    }
}
