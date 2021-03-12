import java.util.HashMap;

public class RunLengthEncoding {
    public static void main(String[] args) {

        System.out.println(runLengthEncoding("AAAAA5AAAAAAAABBCCCCDD")
        );
    }

    public static String runLengthEncoding(String string) {
        char[] charArr = string.toCharArray();
        StringBuilder st = new StringBuilder();
        char prev = charArr[0];
        int count = 1;
        char curr = charArr[0];
        for (int i = 1; i < charArr.length; i++) {
            curr = charArr[i];
            if (curr == prev) {
                count++;
            } else {
                addChar(count, prev, st);
                count = 1;
            }
            prev = curr;
        }

        addChar(count, curr, st);

        return st.toString();
    }

    private static void addChar(int count, char ch, StringBuilder st){
        if (count != 1) {
            if (count>=10){
                int base = count/9;
                int diff = count % 9;
                for (int j = 1; j <= base; j++) {
                    st.append("9").append(ch);
                }
                st.append(diff).append(ch);
            }else {
                st.append(count).append(ch);
            }
        } else {
            st.append(ch);
        }
    }
}
