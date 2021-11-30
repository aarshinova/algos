import java.util.*;

class SameBSTs {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size()!=arrayTwo.size()){
            return false;
        }

        if (arrayOne.size()==0 && arrayTwo.size()==0){
            return true;
        }

        if (arrayOne.get(0)!=arrayTwo.get(0)){
            return false;
        }

        ArrayList<Integer> leftSideArrOne = findLeftSide(arrayOne);
        ArrayList<Integer> leftSideArrTwo = findLeftSide(arrayTwo);

        ArrayList<Integer> rightSideArrOne = findRightSide(arrayOne);
        ArrayList<Integer> rightSideArrTwo = findRightSide(arrayTwo);


        return sameBsts(leftSideArrOne, leftSideArrTwo) && sameBsts(rightSideArrOne, rightSideArrTwo);
    }

    public static ArrayList<Integer> findLeftSide(List<Integer> array){
        ArrayList<Integer> leftSideArr = new ArrayList<>();
        for (int i=1; i< array.size();i++) {
            int el = array.get(i);
            if (el<array.get(0)){
                leftSideArr.add(el);
            }
        }

        return leftSideArr;
    }

    public static ArrayList<Integer> findRightSide(List<Integer> array){
        ArrayList<Integer> rightSideArr = new ArrayList<>();
        for (int i=1; i< array.size();i++) {
            int el = array.get(i);
            if (el>=array.get(0)){
                rightSideArr.add(el);
            }
        }

        return rightSideArr;
    }
}
