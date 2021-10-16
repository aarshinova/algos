import java.util.*;

// Tournament winner
public class TournamentWinner {
    public static void main(String[] args) {
        List<List<String>> competitions = new ArrayList<>(Arrays.asList());
        String[] tmp = new String[]{"HTML", "C#"};
        competitions.add(Arrays.asList(tmp));
        String[] tmp2 = new String[]{"C#", "Python"};
        competitions.add(Arrays.asList(tmp2));
        String[] tmp3 = new String[]{"Python", "HTML"};
        competitions.add(Arrays.asList(tmp3));

        Integer[] resTmp = new Integer[]{0,0,1};
        List<Integer> results = Arrays.asList(resTmp);
        System.out.println("The winner is : " + tournamentWinner(competitions, results));

    }

    public static String tournamentWinner(
            List<List<String>> competitions, List<Integer> results) {
        if (competitions.size()!=results.size())
            return "";
        HashMap<String,Integer> scores= new HashMap<>();
        for (int i=0; i<competitions.size(); i++){
            List<String> round = competitions.get(i);
            String homeTeam = round.get(0);
            String awayTeam = round.get(1);
            if (results.get(i)==0){
                setScores(scores, awayTeam);
            }else {
                setScores(scores, homeTeam);
            }
        }

        int max = -1;
        String name="";
        for (Map.Entry<String,Integer> val : scores.entrySet()){
             if (max<val.getValue()){
                 max = val.getValue();
                 name = val.getKey();
             }
        }

        return name;
    }

    public static void setScores(HashMap<String, Integer> scores, String team){
        if (scores.containsKey(team)) {
            int val = scores.get(team);
            scores.put(team, val + 1);
        }else {
            scores.put(team, 1);
        }
    }


}
