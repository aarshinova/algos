import java.util.Arrays;

class TandemBicycle {

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};
        boolean fastest = true;
        var output = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, false);
        System.out.print(output);

    }

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int sum = 0;

        for (int i=0; i<blueShirtSpeeds.length; i++){
            int val1 = blueShirtSpeeds[i];
            if (fastest) {
                int val2 = redShirtSpeeds[redShirtSpeeds.length-1-i];
                sum += Math.max(val1, val2);
            }else {
                int val2 = redShirtSpeeds[i];
                sum += Math.max(val1, val2);
            }
        }

        return sum;
    };
}
