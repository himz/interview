package leetcode.tree;

import common.TreeNode;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal
 * Medium
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 *
 * Output:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 *
 * Examples 2:
 *
 * Input: [3,9,8,4,0,1,7]
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *
 * Output:
 *
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 *
 * Examples 3:
 *
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 *
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 *
 * Output:
 *
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 *
 *   https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */
/**
 * Vertical Order traversal - assume, root is at 0, and left is at -1 and right is at +1. Continue down the tree,
 * Do level order traversal(bfs), and keep on putting the answers into output list.
 */

public class _314_VerticalOrderTraversal {
    // Incorrect solution. Associate height of the node to the node too. Now the lists, should be sorted by height too.

    TreeMap<Integer, List<Integer>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap<>();
        dfsUtil(root, 0);
        List<List<Integer>> result = new ArrayList<>();
        // Convert map to list, starting from
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> tmpList = entry.getValue();
            result.add(tmpList);
        }
        return result;
    }

    // THis code is
    void dfsUtil(TreeNode root, int nodeVal) {
        if(root == null)
            return;
        List<Integer> list;
        if(map.containsKey(nodeVal)) {
            list = map.get(nodeVal);
        } else {
            list = new ArrayList<>();
        }
        list.add(root.val);
        map.put(nodeVal, list);

        int leftVal = nodeVal - 1;
        int rightVal = nodeVal + 1;

        dfsUtil(root.left, leftVal);
        dfsUtil(root.right, rightVal);


    }
}
