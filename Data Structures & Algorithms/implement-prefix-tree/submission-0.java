// class PrefixTree {

//     public PrefixTree() {
         
//     }

//     public void insert(String word) {

//     }

//     public boolean search(String word) {

//     }

//     public boolean startsWith(String prefix) {

//     }
// }

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] charArr = word.toLowerCase().toCharArray();

        TrieNode next = root;
        for(char c : charArr){
            if(next.trieArr[c-'a'] == null) next.trieArr[c-'a'] = new TrieNode();
            next = next.trieArr[c-'a'];
        }

        next.isEnd = true; 
    }
    
    public boolean search(String word) {
       TrieNode next = walk(word);

        return next == null ? false : next.isEnd; 
    }

    private TrieNode walk(String prefix){
        char[] charArr = prefix.toCharArray();
        
        TrieNode next = root;
        for(char c : charArr){
            if(next.trieArr[c-'a'] == null) return null;
            else next = next.trieArr[c-'a'];
        }

        return next;
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode next = walk(prefix);
        
        return next != null ; 
    }
}

class TrieNode {
    public boolean isEnd=false;
    public TrieNode[] trieArr = new TrieNode[26];
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
