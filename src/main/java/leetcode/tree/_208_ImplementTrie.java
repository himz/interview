package leetcode.tree;

import common.TreeNode;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 *
 *     You may assume that all inputs are consist of lowercase letters a-z.
 *     All inputs are guaranteed to be non-empty strings.
 */
public class _208_ImplementTrie {
    public static void main(String []args) {
        Trie trie = new Trie();
        /*trie.startsWith("a");*/
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }

}
class TrieNode {
    TrieNode[] next;
    char val;
    boolean isEnd;
    public TrieNode() {
        next = new TrieNode[26];
        isEnd = false;
    }
    public TrieNode(char c) {
        next = new TrieNode[26];
        val = c;
        isEnd = false;
    }
}

class Trie {
    TrieNode rootNode;
    /** Initialize your data structure here. */
    public Trie() {
        rootNode = new TrieNode();
        rootNode.val = '1';
        rootNode.next = new TrieNode[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int levelCounter = 0;
        if(rootNode == null) {

        }
        // Root Node will be null;
        TrieNode q = rootNode;
        for(char c : word.toCharArray()) {
            // Find the character at each level
            if(q.next[c - 'a'] == null) {
                // create a node
                q.next[c -'a'] = new TrieNode();
                TrieNode tmp = q.next[c-'a'];
                tmp.val = c;
                q = tmp;
            } else {
                q = q.next[c -'a'];
            }

        }
        q.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(rootNode == null) {
            return false;
        }
        TrieNode q = rootNode;
        // Iterate over the trie to find the word
        for(char c : word.toCharArray()) {
            if(q.next[c-'a'] != null && q.next[c-'a'].val == c) {
                // Iterate
                q = q.next[c-'a'];
            } else {
                return false;
            }
        }
        if(q.isEnd== true) {
            return true;
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(rootNode == null) {
            return false;
        }
        TrieNode q = rootNode;
        // Iterate over the trie to find the word
        for(char c : prefix.toCharArray()) {
            if(q.next[c-'a'] != null && q.next[c-'a'].val == c) {
                // Iterate
                q = q.next[c-'a'];
            } else {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */