import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ValidStartingCity {

    public static void main(String[] args) {
        int[] distances = new int[] {30, 25, 5, 100, 40};
        int[] fuel = new int[] {3, 2, 1, 0, 4};
        int mpg = 20;
        var actual = validStartingCity(distances, fuel, mpg);
        System.out.println("Result " + actual);
    }

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int[] totalMiles = new int[distances.length];
        for (int i=0; i<fuel.length; i++){
            totalMiles[i] =  fuel[i] * mpg;
        }

        int start = 0;
        int validCity = -1;
        while (start<=distances.length-1){
            if (findValid(distances, totalMiles, start)){
                validCity = start;
                break;
            }
            start++;
        }

        return validCity;
    }

    public static boolean findValid(int[] distances, int[] totalMiles, int i){
        int fuelLeftover=0;
        int numOfCities=1;
        while (numOfCities<=distances.length) {
            if (i==distances.length){
                i=0;
            }
            // d 5 25 15 10 15
            // m 10 20 10 0 30
            int total=0;
            if (fuelLeftover > 0) {
                total = totalMiles[i] + fuelLeftover; //0 25
            }else {
                total = totalMiles[i];
            }
            fuelLeftover = total - distances[i]; // 5 0
            if (fuelLeftover < 0) {
                return false;
            }
            i++; //1 2
            numOfCities++; //1 2
        }

        if (fuelLeftover >= 0) {
            return true;
        }

        return false;
    }

}
