package leetcode.heap.pq;

/**
 * 347. Top K Frequent Elements
 * Medium
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 *
 *     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *     Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *     It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 *     You can return the answer in any order.
 *
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

import java.util.PriorityQueue;

public class _347_TopKFrequentElements {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int arr[] = new int[256];
        for(char c : s.toCharArray()) {
            arr[c] = arr[c] + 1;
        }

        char[] r = new char[s.length()];
        int count = 1;
        // insert sort in correct place.
        PriorityQueue<Integer> q = new PriorityQueue<>((i, j) -> arr[j] -arr[i]);
        for(int i = 0; i < 256; i++) {
            if(arr[i]!=0) {
                q.offer(i);
            }
        }


        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            int i = q.poll();
            while(arr[i]-- > 0)
                sb.append((char) (i));
        }
        return sb.toString();
    }
}