package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _26 {
    public int removeDuplicates(int[] nums) {
        int i =0 , j = 1;
        for(; i < nums.length && j < nums.length;) {
            if(nums[i] >= nums[j]) {
                j++;
            } else  {
                int temp = nums[j];
                nums[j] = nums[i++];
                nums[i] = temp;
            }
        }
        return i+1;
    }

}