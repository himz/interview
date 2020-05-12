package leetcode.sort;

import java.util.Arrays;

public class _283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0,j =0;

        while (j != nums.length -1) {
            if (nums[i] == 0 && nums[j+1] != 0) {
                // swap with next
                swap(nums, i, j + 1);
                i++;
            } else if(nums[j] != 0) {
                i++;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int i, int j) {
        System.out.println(Arrays.toString(nums));
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
