package leetcode.greedy;

import java.util.*;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 *
 *     The length of num is less than 10002 and will be ≥ k.
 *     The given num does not contain any leading zero.
 *
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 * https://leetcode.com/problems/remove-k-digits/
 * Explanation: https://www.youtube.com/watch?v=HXvxIth510g
 */
public class _402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int N = num.length();
        if(k==N) {
            return "0";
        }

        Stack<Character> stk = new Stack<>();
        int i = 0;
        while(i<num.length()){
            while(k>0 && !stk.isEmpty() && stk.peek()>num.charAt(i)){
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
            i++;
        }

        // Handle cases when consecutive nums are there like 3333
        while(k>0){
            stk.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder str = new StringBuilder();

        while(!stk.isEmpty()) {
            str.append(stk.pop());
        }

        str.reverse();

        //remove all the 0 at the head
        while(str.length() > 1 && str.charAt(0)=='0') {
            str.deleteCharAt(0);
        }
        return str.toString();
    }
}
