package leetcode.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Similar leetcode.misc._448_FindDisappearedNumbers
 */
public class _442_FindAllDuplicatesInArray {
    // Tricky solution. Put the numbers in correct place, and then find out of place items. No extra space needed.
    // Other best way is using hashmap.
    public List<Integer> findDuplicates(int[] nums) {

        for(int i = 0; i < nums.length; ) {
            // COndition for swap
            int val = nums[i];
            if(nums[val - 1] != val) {
                // swap
                int tmp = nums[val -1];
                nums[val -1] = val;
                nums[i] = tmp;
            } else {
                // Condition to iterate i = both values equal - no swap needed
                i++;
            }
        }
        List<Integer> numlist = new ArrayList<>();
        // array should be correct in place
        for(int i = 0; i < nums.length;i++) {
            if(nums[i] != i+1){
                numlist.add(nums[i]);
            }
        }

        return numlist;
    }
    public List<Integer> findDuplicatesHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],(map.get(nums[i]) +1));
            } else {
                map.put(nums[i],1);
            }
        }
        List<Integer> numlist = new ArrayList<>();
        // array should be correct in place
        for(  Map.Entry<Integer, Integer> entry :map.entrySet()) {
            if(entry.getValue() == 2){
                numlist.add(entry.getValue());
            }
        }

        return numlist;
    }
}
