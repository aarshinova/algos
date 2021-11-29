import java.util.*;

class ZigZagTraversal {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // go down 
        // go up diag - X steps
        //go right - 1 step ( if possible)
        // go down diag  - X steps
        // go down - - 1 step
        // go up diag


        List<Integer> output = new ArrayList<Integer>();
        int[] coord = {0,0};
        output.add(array.get(0).get(0));

        int i = coord[0];
        int j = coord[1];
        while (i>=0 && j>=0 && i<array.size() && j<array.get(0).size()) {
            if (!moveDown(coord, array, output)){
                break;
            }

            if (!moveUpDiag(coord, array, output)){
                break;
            }
            if(!moveRight(coord, array, output)){
                break;
            }
            if (!moveDownDiag(coord, array, output)){
                break;
            }
        }

        if (array.size()!=1 || array.get(0).size()!=1){
            output.add(array.get(array.size()-1).get(array.get(0).size()-1));
        }
        return output;
    }

    public static Boolean moveDown(int[] arr, List<List<Integer>> array, List<Integer> output){
        int i = arr[0];
        int j = arr[1];
        if ((i+1) < array.size()) {
            i = i + 1;
        }else {
            // move to the right
            if ((j+1) < array.get(0).size() ){
                j = j + 1;
            }
        }
        arr[0] = i;
        arr[1] = j;
        if (i == array.size()-1 && j == array.get(0).size()-1) {
            return false;
        }
        return true;
    }

    public static Boolean moveUpDiag(int[] arr, List<List<Integer>> array, List<Integer> output){
        int i = arr[0];
        int j = arr[1];
        // 4 1
        // 3 2
        while (i>=0 && j>=0 && i<array.size() && j<array.get(0).size()) {
            output.add(array.get(i).get(j));
            i--;
            j++;

            // 1,0 -> 0,1
            // 2,0 -> 1,1 -> 0, 2
            // 3, 0 -> 2,1 -> 1, 2 - > 0, 3
        }
        arr[0] = ++i; //4
        arr[1] = --j; //1
        if (i == array.size()-1 && j == array.get(0).size()-1) {
            return false;
        }
        return true;

    }

    public static Boolean moveRight(int[] arr, List<List<Integer>> array, List<Integer> output){
        int i = arr[0];
        int j = arr[1];
        if ((j+1) < array.get(0).size() ){
            j = j + 1;
        }else {
            if ((i+1) < array.size()) {
                i = i + 1;
            }
        }
        arr[0] = i;
        arr[1] = j;
        if (i == array.size()-1 && j == array.get(0).size()-1) {
            return false;
        }
        return true;
    }

    public static Boolean moveDownDiag(int[] arr, List<List<Integer>> array, List<Integer> output){
        // 0,2 -> 1,1 -> 1,1 -> 2, 0
        // 0, 3 - > 1,2 - > 2,1 - > 3,0
        int i = arr[0];
        int j = arr[1];
        // 3 1
        // 4 0
        // 5 -1
        // 4 0
        while (i>=0 && j>=0 && i<array.size() && j<array.get(0).size()) {
            output.add(array.get(i).get(j));
            i++;
            j--;
        }
        arr[0] = --i;
        arr[1] = ++j;
        if (i == array.size()-1 && j == array.get(0).size()-1) {
            return false;
        }
        return true;
    }


}
