package leetcode.searching.binary;


/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Medium
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 *
 * Constraints:
 *
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     nums is a non-decreasing array.
 *     -109 <= target <= 109
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34_FindFirstAndLastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int [] result = {-1, -1};
        // Find an occurence of target
        int at= binSearch(nums, target, 0, nums.length -1);
        if(at == -1)
            return result; // target not found

        int lo = 0, hi = 0;
        while(at != -1) {
            result[0] = at;
            hi = at -1;
            at = binSearch(nums, target, lo, hi);
        }
        at = result[0];
        hi = nums.length -1;
        while(at != -1) {
            result[1] = at;
            lo = at + 1;
            at = binSearch(nums, target, lo, hi);
        }
        return result;

    }


    int binSearch(int[] nums, int target, int start, int end) {
        int lo = start; int hi = end;


        while(lo <= hi) {
            int mid = lo + (hi -lo)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return -1;
    }

}
