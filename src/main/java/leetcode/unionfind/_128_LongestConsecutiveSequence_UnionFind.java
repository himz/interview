package leetcode.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
// Union Find Solution
    // Better solution is to use optimized array with hash set. Very simple but better. https://leetcode.com/problems/longest-consecutive-sequence/solution/
public class _128_LongestConsecutiveSequence_UnionFind {

    Map<Integer, Node> map = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0 )
            return 0;
        for(int i =0;i<nums.length ; i++) {
            makeset(nums[i]);
        }

        // Iterate over map

        for(Integer i : map.keySet()) {
            if(map.containsKey(i-1)) {
                union(map.get(i), map.get(i-1));
            }

            if(map.containsKey(i+1)){
                union(map.get(i), map.get(i+1));
            }
        }
        int max = Integer.MIN_VALUE;
        for(Integer i : map.keySet()) {
           if(map.get(i).size > max) {
               max = map.get(i).size;
           }
        }
        return max;
    }


    void makeset(int val) {
        if (map.containsKey(val)) {
            return;
        }

        Node node = new Node();
        node.val = val;
        node.parent = node;
        node.size = 1;
        map.put(val, node);
        return ;
    }

    void union(Node n1, Node n2 ) {
        Node p1 = find(n1);
        Node p2 = find(n2);

        if(p1 == p2)
            return;

        p1.parent = p2;
        p2.size = p2.size + p1.size;
    }

    Node find(Node n1){
        if(n1 == null)
            return null;
        if(n1.parent == n1) {
            return n1;
        }
        return find(n1.parent);
    }


    class Node {
        Node parent;
        int val;
        int size;
    }

}
