public class FirstDuplicate {
    public static void main(String[] args) {

        int result = firstDuplicateValue(
                new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(result);
    }



    public static int firstDuplicateValue(int[] array) {
        if (array.length==1)
            return -1;
        for (int i=0; i<array.length; i++){
            int val = array[i];
            if (array[Math.abs(val)-1]<0){
                return Math.abs(val);
            }
            array[Math.abs(val)-1] *= -1;
        }
        return -1;
    }
}
