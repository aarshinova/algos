import java.util.*;

public class YoungestCommonAnsector {

    public static HashMap<Character, AncestralTree> getTrees() {
        var trees = new HashMap<Character, AncestralTree>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new AncestralTree(a));
        }

        trees
                .get('A')
                .addAsAncestor(
                        new AncestralTree[] {
                                trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F')
                        });
        return trees;
    }

    public static void main(String[] args) {
        var trees = getTrees();
        trees.get('A').addAsAncestor(new AncestralTree[] {trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[] {trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[] {trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[] {trees.get('F'), trees.get('G')});

        var yca = getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));

        System.out.println("result " + yca);

    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
       Stack<AncestralTree> descOneAncestor = new Stack<>();
       Stack<AncestralTree> descTwoAncestor = new Stack<>();
        AncestralTree currAncestor1 = null;
        AncestralTree currAncestor2 = null;

        if (descendantOne.ancestor!=null){
            currAncestor1 = descendantOne.ancestor;
            descOneAncestor.add(currAncestor1);
        }
        if (descendantOne.ancestor!=null){
            currAncestor2 = descendantTwo.ancestor;
            descTwoAncestor.add(currAncestor2);
        }

       while (currAncestor1!=null && currAncestor1.ancestor!=null){
           descOneAncestor.add(currAncestor1.ancestor);
           currAncestor1 = currAncestor1.ancestor;
       }
        while (currAncestor2!=null && currAncestor2.ancestor!=null){
            descTwoAncestor.add(currAncestor2.ancestor);
            currAncestor2 = currAncestor2.ancestor;
        }

        AncestralTree commonAns = topAncestor;
       while (!descOneAncestor.isEmpty() && !descTwoAncestor.isEmpty()){
           AncestralTree tree1 = descOneAncestor.pop();
           AncestralTree tree2 = descTwoAncestor.pop();

           if (tree1.name==tree2.name) {
               commonAns = tree1;
           }
           else{
               break;
           }
       }

        return commonAns; // Replace this line
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}

