package leetcode.heap.pq;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */

import java.util.PriorityQueue;

/**
 * Algo: GOt it from discussion. Based on Priority Queue.
 *       Idea is to pass in a comparator to the priority queue, to do the "insertion sort" part of the code.
 *       https://leetcode.com/problems/sort-characters-by-frequency/discuss/645049/Java-Simple-Code
 */
public class _451_SortCharByFrequency {
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