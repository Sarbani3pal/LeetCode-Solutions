class Solution {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        String s;
        boolean isWord;
        
        public TrieNode() {
            children = new HashMap<>();
            s = null;
            isWord = false;
        }
    }
    
    class Trie {
        TrieNode root;
        Map<String, Integer> count;
        public Trie() {
            root = new TrieNode();
            count = new HashMap<>();
        }
        
        public boolean isWord(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            return cur.isWord;
        }
        
        public void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                   cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
            cur.s = s;
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
    }
    public List<Integer> findSubstring(String s, String[] words) {
        Trie tree = new Trie();
        int total = 0;
        for (String temp : words) {
            tree.insert(temp);
            total += temp.length();
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i <= s.length() - total; i++) {
            String sub = s.substring(i, i + total);
            if (isValid(sub, tree, words[0].length())) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean isValid(String temp, Trie tree, int gaps) {
        Map<String, Integer> visited = new HashMap<>();
        for (int i = 0; i <= temp.length() - gaps; i += gaps) {
            String s = temp.substring(i, i + gaps);
            visited.put(s, visited.getOrDefault(s, 0) + 1);
            
            if (!tree.isWord(s)) {
                return false;
            }
            if (visited.get(s) > tree.count.get(s)) {
                return false;
            }
        }
        return true;
    }
}