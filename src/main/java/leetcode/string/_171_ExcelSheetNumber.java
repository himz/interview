package leetcode.string;

/**
 * 171. Excel Sheet Column Number
 * Easy
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 *
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 *
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 7
 *     s consists only of uppercase English letters.
 *     s is between "A" and "FXSHRXW".
 *     https://leetcode.com/problems/excel-sheet-column-number/
 */
public class _171_ExcelSheetNumber {
    public int titleToNumber(String s) {
        int power = 0;
        int sum = 0;
        for(int i = s.length() -1; i >= 0; i--) {
            int valOf = s.charAt(i) - 'A' +1;
            System.out.println(valOf);
            sum = valOf * (int)Math.pow(26, power) + sum;
            power++;
        }
        return sum;

    }
}
