import java.util.*;

class SuffixTrieConstruction {

    public static void main(String[] args) {
        var trie = new SuffixTrie("babc");
        System.out.println(trie.contains("abc"));
        System.out.println(trie.contains("bc"));
        System.out.println(trie.contains("ab"));
        System.out.println(trie.contains("abfhfjfjfjfjgftur"));
    }


    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    public static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // O(n^2) time O(n^2) space
        public void populateSuffixTrieFrom(String str) {
            for (int j=0; j<str.length(); j++){
                populate(str, j);
            }
        }

        private void populate(String str, int j) {
            TrieNode node = root;
            for (int i = j; i< str.length(); i++){
                char ch = str.charAt(i);
                if (!node.children.containsKey(ch)){
                    TrieNode newNode = new TrieNode();
                    node.children.put(ch, newNode);
                }
                node = node.children.get(ch);
            }
            node.children.put(endSymbol, null);
        }

        //O(m) time O(1) space
        public boolean contains(String str) {
            TrieNode node = root;
            for (int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if (!node.children.containsKey(ch)){
                    return false;
                }else {
                    node = node.children.get(ch);
                }
            }
            return node.children.containsKey(endSymbol);
        }
    }

}
