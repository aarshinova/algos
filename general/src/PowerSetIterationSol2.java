import java.util.*;

class PowerSetIterationSol2 {
    public static void main(String[] args) {
        // 135 1245
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        powerset(input);
       // System.out.println(powerset(input));
        //System.out.println(powerset(input).size());
    }
    /*Solution using BFS*/
    public static List<List<Integer>> powerset(List<Integer> array) {
        ArrayList<HashSet<Integer>> result = new ArrayList<HashSet<Integer>>();
        result.add(new HashSet<>());
        Boolean added;

       for (int k=0;k<result.size();k++){
            HashSet<Integer> currSet = result.get(k);
            added = false;
            for (int j = 0; j < array.size(); j++) {
                Integer currValue = array.get(j);
                if (currSet.isEmpty()) {
                    init(result, currValue);
                    added = true;
                } else {
                        if (!currSet.contains(currValue)) {
                            HashSet tmp = new HashSet<>(currSet);
                            tmp.add(currValue);
                            if (!result.contains(tmp)) {
                                result.add(tmp);
                            }
                            System.out.println("res : " + result);
                            added = true;
                        }
                }
            }
            if (!added){
                break;
            }
        }

        return convertToArrayList(result);
    }

    private static List<List<Integer>> convertToArrayList(ArrayList<HashSet<Integer>> result) {
        List<List<Integer>> finalRes = new ArrayList<List<Integer>>();
        for (HashSet<Integer> setToAdd: result){
            ArrayList<Integer> newArr = new ArrayList<>();
            for (Integer val:setToAdd){
                newArr.add(val);
            }
            finalRes.add(newArr);
        }
        return finalRes;
    }

    private static void init(ArrayList<HashSet<Integer>> result, Integer currValue) {
        HashSet tmp = new HashSet<>();
        tmp.add(currValue);
        result.add(tmp);
    }

}
