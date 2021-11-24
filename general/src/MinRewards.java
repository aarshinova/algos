import java.util.*;

class MinRewards {
    public static Integer prevSize = null;
    public static Boolean prevDir = null;
    public static int minRewards(int[] scores) {
        int[] rewards = new int [scores.length];
        if (scores.length==1){
            return 1;
        }

        prevSize = null;
        prevDir = null;
        int startInd = -1;
        Boolean inc = null;
        int endInd = -1;
        int i = 0;
        for (i=0; i < scores.length-1; i++){
            if (startInd < 0){
                startInd = i; //0
            }
            if (scores[i+1] - scores[i] > 0 && inc == null) {
                inc = true;
            }	else if (scores[i+1] - scores[i] < 0 && inc == null) {
                inc = false;
            }
            else if (scores[i+1] - scores[i] < 0 && inc){
                rewards = assignRewards(scores, rewards, startInd, i, inc);
                if (i!=scores.length-2) i = i - 1;
                startInd = -1;
                inc = null;
            }
            else if (scores[i+1] - scores[i] > 0 && !inc){
                rewards = assignRewards(scores, rewards, startInd, i, inc);
                if (i!=scores.length-2) i = i - 1;
                startInd = -1;
                inc = null;
            }
        }

        //edge c
        if(i == scores.length-1){
            if (inc!=null){
                rewards = assignRewards(scores, rewards, startInd, scores.length-1, inc);
            }
            else {
                if (scores[i] - scores[i-1] > 0) {
                    rewards[scores.length-1]=2;
                }else {
                    rewards[scores.length-1]=1;
                }
            }
        }

        int sum = 0;
        for (int j=0; j<rewards.length; j++){
            sum += rewards[j];
        }

        return sum;
    }

    public static int[] assignRewards(int[] scores, int[] rewards, int startInd, int endInd, Boolean inc){
        // edge case
        if (prevDir!=null && prevSize!=null && prevSize>(endInd - startInd + 1) && prevDir && !inc){
            startInd = startInd + 1;
        }

        int maxReward = (inc) ? 1 : (endInd - startInd) + 1;

        for (int j=startInd; j<=endInd; j++){
            if (inc) {
                rewards[j] = maxReward;
                maxReward++;
            }else{
                rewards[j] = maxReward;
                maxReward--;
            }
        }

        prevSize = (endInd - startInd) + 1;
        prevDir = inc;

        return rewards;
    }
}