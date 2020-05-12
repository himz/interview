package leetcode.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
// #Math XOR concept
public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : nums) {
            if(map.containsKey(i)) {
                int val = map.get(i);
                map.put(i ,++val);
            } else {
                map.put(i, 1);
            }
        }

        for(Integer in : map.keySet()) {
            if(map.get(in) == 1) {
                return in;
            }
        }
        return 0;
    }

    // Better solution XOR all the elements
    public int singleNumber1(int[] nums) {
        int ans =0;

        int len = nums.length;
        for(int i=0;i!=len;i++)
            ans ^= nums[i];

        return ans;

    }
}
