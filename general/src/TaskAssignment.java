import java.util.*;

class TaskAssignment {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>  res = taskAssignment(3, new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4)));
        for (ArrayList<Integer> tmp : res) {
            System.out.println("Result is " + tmp);
        }
    }

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // 1 1 3 3 4 5
        // 1 8 9 10
        ArrayList<List<Integer>> resVal = new ArrayList<>();
        ArrayList<List<Integer>> indexesMap = new ArrayList<>();

        for (int i=0; i<tasks.size(); i++){
            indexesMap.add(new ArrayList<>(Arrays.asList(tasks.get(i), i)));
        }

        // 1 1  3  3  4  5
        Collections.sort(tasks);

        for (int i=0; i<tasks.size()/2; i++){
            resVal.add(new ArrayList<>(Arrays.asList(tasks.get(i), tasks.get(tasks.size()-i-1))));
        }

        // resVal 1,5 1,4 3,3
        ArrayList<ArrayList<Integer>> resInd = new ArrayList<>();
        for (List<Integer> el : resVal){
            ArrayList<Integer> newEntry = new ArrayList<>();
            // 1
            int indx1 = findIndex(el.get(0), indexesMap);
            // 5
            int indx2 = findIndex(el.get(1), indexesMap);
            resInd.add(new ArrayList<Integer>(Arrays.asList(indx1,indx2)));
        }


        return resInd;
    }

    public static int findIndex(int value, ArrayList<List<Integer>> indexesMap){
        int indx = -1;
        for (List<Integer> val : indexesMap){
            if(val.get(0)==value){
                indx = val.get(1);
                break;
            }
        }
        indexesMap.remove(new ArrayList<>(Arrays.asList(value,indx)));
        return indx;
    }
}
