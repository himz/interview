package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 140. Word Break II
 * Hard
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 *
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<>();

        dfs(result, new HashSet<String>(wordDict), s, "");

        return result;

    }


    void dfs(List<String> result, HashSet<String> set, String s, String tmpString) {
        if(s == null || s.isEmpty()) {
            result.add(tmpString);
            return ;
        }

        StringBuilder sb = new StringBuilder();
        for(int i  = 0; i < s.length(); i++) {
            //String tmp = s.substring(0, i);


            sb.append(s.charAt(i));
            String tmp = sb.toString();
            if(set.contains(tmp)) {
                String nextString = tmpString.length() == 0 ? tmp : tmpString + " " + tmp;
                dfs(result, set, s.substring(i + 1, s.length()), nextString);
            }

        }



    }


}