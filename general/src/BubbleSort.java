// Tournament winner
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(bubbleSort(new int[] {1, 0, 21, 33, 45, 45, 61, 71, 72, 73}));
    }

    public static int[] bubbleSort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i=1; i<array.length; i++){
                if (array[i-1]>array[i]){
                    swap(i-1,i, array);
                    swapped = true;
                }
            }
        }while (swapped==true);
        return array;
    }

    public static void swap(int i, int j, int[] array){
        int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
    }
}
