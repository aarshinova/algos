import java.util.*;

public class FirstNotRepChar {
    public static void main(String[] args) {
        System.out.println("Res " + firstNonRepeatingCharacter("abcdcaf"));
    }

    public static int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> noRepChar = new HashMap<>();
        for (int i=0; i<string.length();i++){
            char ch = string.charAt(i);
            if (noRepChar.containsKey(ch)){
                noRepChar.put(ch, -1);
            }
            else {
                noRepChar.put(ch, i);
            }
        }

        int res = -1;
        for (Map.Entry<Character, Integer> ch : noRepChar.entrySet()){
            if (ch.getValue()==-1)
                continue;
            else {
                res = ch.getValue();
            }
        }

        return res;
    }
    }

