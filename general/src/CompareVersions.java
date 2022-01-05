//Given two version numbers, version1 and version2, compare them.
//
//Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
//
//To compare version numbers,
// compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring
// any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number
// does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1
// because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

public class CompareVersions {
    public static void main(String[] args) {

    }

    class Solution {
        // 0.1.4.5 and 0.1.5.3
        //
        // 1.0.3 and 0.1
        // 0.1.4 and 0.1.4.3

        public int compareVersion(String version1, String version2) {
            String[] arr1 = version1.split("\\.");
            String[] arr2 = version2.split("\\.");

            int len1 = arr1.length;
            int len2 = arr2.length;

            int len = Math.max(len1, len2);
            for (int i = 0; i < len; i++) {
                Integer numb1 = null;
                Integer numb2 = null;
                if (i < len1) {
                    numb1 = Integer.parseInt(arr1[i]);
                } else {
                    numb1 = 0;
                }
                if (i < len2) {
                    numb2 = Integer.parseInt(arr2[i]);
                } else {
                    numb2 = 0;
                }

                if (numb1 > numb2) {
                    return 1;
                } else if (numb1 < numb2) {
                    return -1;
                }
            }

            return 0;
        }

    }


}
