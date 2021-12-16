class Solution {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    // 110 cx
    public String intToRoman(int num) {
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (num>0 && i<values.length) {
            if (num>=values[i]){
                num -= values[i];
                sb.append(symbols[i]);
            }else {
                i++;
            }
        }

        return sb.toString() ;
    }
}