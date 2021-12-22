import java.util.HashMap;

class RomanToInt {
    public static HashMap<String, Integer> mapVals = new HashMap<>();


    //public static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    //public static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    // M CM XC II

    public int romanToInt(String s) {
        mapVals.put("M", 1000);
        mapVals.put("CM", 900);
        mapVals.put("D", 500);
        mapVals.put("CD", 400);
        mapVals.put("C", 100);
        mapVals.put("XC", 90);
        mapVals.put("L", 50);
        mapVals.put("XL", 40);
        mapVals.put("X", 10);
        mapVals.put("IX", 9);
        mapVals.put("V", 5);
        mapVals.put("IV", 4);
        mapVals.put("I", 1);
        int number = 0;

        // III
        for (int i=0; i<s.length(); i++){
            char curr = s.charAt(i); // I
            String symb = "" + curr; //
            if (i<s.length()-1){
                char nextCurr = s.charAt(i+1);
                symb += nextCurr;
                if (mapVals.containsKey(symb)){
                    number += mapVals.get(symb);
                    i++;
                }else {
                    number += mapVals.get(""+curr);
                }
            }else{
                number += mapVals.get(symb);
            }

        }

        return number;
    }
}