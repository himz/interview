package leetcode.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 * https://leetcode.com/problems/valid-palindrome/
 */
public class _125_ValidPalindrome {
    // Valid but compliacted way. Basically, go over the whole string, an skip any non-alpha numeric char. Better to pre-process
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();

        int len = s.length();
        for(int i = 0, j = len -1; i < len && j>=0; i++, j--) {
            while(!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))){
                i++;
                if(i >= len) {
                    return true;
                }
            }
            while(!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))){
                j--;
                if(j <0) {
                    return true;
                }
            }
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
