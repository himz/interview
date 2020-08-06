package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 *
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * Similar: https://leetcode.com/problems/implement-trie-prefix-tree/solution/
 */
/* Although, ideally this should be done via trie, but given for the question, search words
    are complete words, we can use map to save our DS. Simplifies the code a lot. COpied answer: https://leetcode.com/problems/add-and-search-word-data-structure-design/discuss/59669/Java-Solution-easy-understand

 */
public class _211_AddSearchWord_Trie {
     Map<Integer, List<String>> map = new HashMap<>();
    public void addWord(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(index, list);
        } else {
            map.get(index).add(word);
        }
    }


    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            return false;
        }

        List<String> list = map.get(index);
        for(String s : list) {
            if(isSame(s, word)) { // when word has '.'
                return true;
            }
        }
        return false;
    }

    public boolean isSame(String s, String word) { // word has '.'
        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
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