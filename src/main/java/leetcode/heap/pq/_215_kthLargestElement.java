package leetcode.heap.pq;

/**
 * 215. Kth Largest Element in an Array
 * Medium
 * <p>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * <p>
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * <p>
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class _215_kthLargestElement {
    // SImplest PQ approach
    public int findKthLargestMethod1(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new The_Comparator());
        // iterate over the stream of elements.
        for (int i = 0; i < nums.length; i++) {
            // Put them in the PQ.
            pq.add(nums[i]);
        }
        //System.out.println(pq);
        // poll for k times
        for (int j = 0; j < k - 1; j++) {
            pq.poll();
        }

        return pq.poll();

    }
    // Create min queue, and remove elements if not needed
    public int findKthLargestMethod2(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        // Min Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // iterate over the stream of elements.
        for (int i = 0; i < nums.length; i++) {
            // Put them in the PQ.
            pq.add(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    // Quick Select - Using i, j = 0
    public int findKthLargestMethod3(int[] nums, int k) {
        k = nums.length - k; // convert to index of k largest
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int i = l; // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
            for (int j = l + 1; j <= r; j++)
                if (nums[j] < nums[l]) swap(nums, j, ++i);
            swap(nums, l, i);

            if (k < i) r = i - 1;
            else if (k > i) l = i + 1;
            else return nums[i];
        }
        return -1; // k is invalid
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


class The_Comparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
        if(y - x > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}