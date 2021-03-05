import java.util.*;

// Tournament winner
public class ClassPhotos {
    public static void main(String[] args) {

        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(3, 5, 6, 8, 2));
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(2, 4, 7, 5, 1));

        boolean expected = true;
        boolean actual = classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println("The photo can be taken : " + (expected == actual));
    }

    // 1 3 4 5 8
    // 2 4 5 6 9

    //[3, 5, 6, 8, 2] 2 3 5 6 8
    //[2, 4, 7, 5, 1] 1 2

    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        if (redShirtHeights.size() != blueShirtHeights.size())
            return false;
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean redInFront = false;
        boolean blueInFront = false;
        if (redShirtHeights.get(0) < blueShirtHeights.get(0)) {
            redInFront = true;
        } else if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            blueInFront = true;
        } else {
            return false;
        }

        for (int idx = 1; idx < redShirtHeights.size(); idx++) {
            if (redInFront) {
                if (!checkHeight(redShirtHeights.get(idx), blueShirtHeights.get(idx)))
                    return false;
            }
            if (blueInFront) {
                if (!checkHeight(blueShirtHeights.get(idx), redShirtHeights.get(idx)))
                    return false;
            }
        }
        return true;
    }

    public static boolean checkHeight(Integer frontTeamMember, Integer backTeamMember) {
        if (frontTeamMember < backTeamMember) {
            return true;
        } else {
            return false;
        }
    }
}
