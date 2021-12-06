import java.util.*;

class MaxSymIncSubsq {
    public static void main(String[] args) {
        //10, 15, 11, 14, 50
        maxSumIncreasingSubsequence(new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        ArrayList<List<Integer>> sequence = new ArrayList<>();
        ArrayList<Integer> maxSum = new ArrayList<>();
        if (array.length == 0) {
            return new ArrayList<>();
        }
        if (array.length == 1) {
            return new ArrayList<>() {
                {
                    add(List.of(array[0]));
                    add(List.of(array[0]));
                }
            };
        }

        for (int i = 0; i < array.length; i++) {
            maxSum.add(i, array[i]);
            sequence.add(i, new ArrayList<>(List.of(array[i])));
        }

        // 3 10 2 11
        // 1 1  1  1
        // 1 2  1  2
        // 1 2  1  3
        //.1 2  1  3
        // 3 13  2 24

        //10, 15, 11, 14, 50
        //10  25  21  35  50
        //10  25  21  35  60
        // 10 25  21  35  75
        // 10 25  21  35  75
        // 10 25  21  35  85

        for (int i = 1; i < array.length; i++) {
            ArrayList<Integer> subSeq = new ArrayList<>();
            for (int j = 0; j <= i - 1; j++) {
                if (array[i] > array[j]) {
                    if (maxSum.get(i) < (array[i] + maxSum.get(j))) {
                        List<Integer> oldValues = sequence.get(i);
                        subSeq.removeAll(oldValues);
                        List<Integer> arr = sequence.get(j);
                        for (int val : arr) {
                            if (!subSeq.contains(val)) {
                                subSeq.add(val);
                            }
                        }
                        maxSum.set(i, (array[i] + maxSum.get(j)));

                    }
                }
                if (!subSeq.contains(array[i])) {
                    subSeq.add(array[i]);
                }
                sequence.set(i, subSeq);
            }
        }

        Integer max = maxSum.get(0);
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < maxSum.size(); i++) {
            int el = maxSum.get(i);
            if (el > max) {
                max = el;
                resList = sequence.get(i);
            }
        }
        final int res = max;

        final List<Integer> finalResList = resList.size() == 0 ? List.of(array[0]) : resList;
        return new ArrayList<>() {
            {
                add(List.of(res));
                add(finalResList);
            }
        };
    }
}
