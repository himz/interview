package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 *
 *
 * Constraints:
 *
 *     The number of elements of the BST is between 1 to 10^4.
 *     You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *     https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

/**
 * Algo: 1) BST inorder traversal iterates by rank only.
 *       2) If at any node in inorder traversal, we find that value is reached, store it in some location.
 */
public class _230_KthSmallestBst {
    public int kthSmallest(TreeNode root, int k) {

        if(root == null) {
            return 0;
        }
        int arr[] = new int[1];
        helper(root, k, 0, arr);
        return arr[0];
    }


    public int helper(TreeNode root, int k, int value, int arr[]) {

        if(root == null) {
            return value;
        }

        if(value == k) {
            return value;
        }


        int left = helper(root.left, k, value, arr);
        int nodeVal = left + 1;
        if(nodeVal == k ) {
            arr[0] = root.val;
        }

        int right = helper(root.right, k, nodeVal, arr);

        return right;


    }
}