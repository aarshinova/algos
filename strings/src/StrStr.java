//Implement strStr().
//
//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
public class StrStr {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;

        int lenH = haystack.length();
        int lenN = needle.length();
        char[] hay = haystack.toCharArray();
        char[] needl = needle.toCharArray();

        while (pointer1 < lenH) {
            char char1 = hay[pointer1]; //b
            char char2 = needl[0]; //b
            if (char1 == char2) {
                pointer2 = 0;
                pointer3 = pointer1; //0
                while (pointer2 < lenN && pointer3 < lenH) {
                    char2 = needl[pointer2];
                    char1 = hay[pointer3];
                    if (char1 != char2) {
                        break;
                    }
                    pointer2++;
                    pointer3++;

                }

                if (pointer2 == lenN) {
                    return pointer1;
                }
            }
            pointer1++;
        }

        return -1;
    }
}

