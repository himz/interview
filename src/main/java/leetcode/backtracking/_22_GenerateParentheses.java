package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * https://leetcode.com/problems/generate-parentheses/
 *
 */
public class _22_GenerateParentheses {
    /**
     * Algo - Naive SOlution
     *         1) Find all permutations of the parenthesis.
     *         2) Ignore the ones which are bad.
     */
    public List<String> generateParenthesis(int n) {

        if(n<= 0) {
            return new ArrayList<String>();
        }

        List<List<Character>> result = new ArrayList<>();
        char[] c = new char[2*n];
        int i = 0;
        for(; i < 2*n; i++) {
            if(i < n) {
                c[i] = '(';
            } else {
                c[i] = ')';
            }
        }

        // Convert result to List<String>
        backtrack(c, new ArrayList<Character>(), result, 2*n, 0, new boolean[2*n]);

        // COnvert to string
        List<String> resultString = new ArrayList();

        // validate and add to final string
        for(List<Character> r : result) {
            StringBuilder sb = new StringBuilder();
            int open = 0;
            int close = 0;
            boolean flag = false;
            for(Character d : r) {
                if(d == '(') {
                    open++;
                }
                if(d == ')') {
                    close++;
                }

                if(close > open) {
                    // skip that string
                    flag = true;
                }
                sb.append(d);
            }
            if(!flag) {
                resultString.add(sb.toString());
            }
        }

        return resultString;

    }

    // Find all permutations
    void backtrack(char[] s, List<Character> tmpList, List<List<Character>> result, int size, int start, boolean[] used) {

        if(tmpList.size() == s.length) {
            result.add(new ArrayList<>(tmpList));
        }


        for(int i = start; i < size ; i++) {
            if(used[i] == true) {
                continue;
            }
            used[i] = true;
            tmpList.add(s[i]);
            backtrack(s, tmpList, result, size, 0, used);

            tmpList.remove(tmpList.size() -1);
            used[i] = false;

            while(i+1 <  s.length &&  s[i] ==  s[i+1]) {
                i++;
            }
        }


    }

}