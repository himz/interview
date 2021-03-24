package leetcode.string;

import java.util.ArrayDeque;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * Medium
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 *     It is the empty string, contains only lowercase characters, or
 *     It can be written as AB (A concatenated with B), where A and B are valid strings, or
 *     It can be written as (A), where A is a valid string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 *
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 *
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 * Example 4:
 *
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 10^5
 *     s[i] is one of  '(' , ')' and lowercase English letters.
 *
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */

/**
 * Algo is straigtforward what is implemented. Now better would be to not use stack
 * as we just need to keep track of the open brackets.
 * IDea:
 * - we know if there are etc ')', we can remove them right away. DO that.
 * - REverse the string, and do the same thing with etc '('
 * - reverse the string again and return the ans.
 */
public class _1249_MakeStringValidParanthesis {
    public String minRemoveToMakeValid(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();     // push location of the open bracket

        String result = "";
        char [] chars = s.toCharArray();
        int count = 0;
        for(int i = 0; i < chars.length ; i++) {
            if(chars[i] == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    // this is an invalid bracket - remove
                    chars[i] = 'A';
                    count++;
                } else {
                    // remove an element from the stack.
                    stack.pop();
                }
            }
        }

        // post process
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            chars[tmp] = 'A';
            count++;
        }

        char[] resArr = new char[chars.length - count];
        //StringBuilder sb = new StringBuilder();
        int k = 0;
        for(char ch : chars) {
            if(ch != 'A')
                resArr[k++] = ch;
        }

        return new String(resArr);

    }
}
