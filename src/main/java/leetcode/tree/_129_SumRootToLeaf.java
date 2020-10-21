package leetcode.tree;

import common.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 * Medium
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class _129_SumRootToLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0, 0);
        return sum;
    }



    void dfs(TreeNode root, int val, int depth) {

        if(root == null) {
            return;
        }

        int temp = val * 10 + root.val;

        if(root.left == null && root.right == null) {
            //leaf node - add to sum
            sum  = sum + temp;
        }


        dfs(root.left, temp, depth + 1);
        dfs(root.right, temp, depth + 1);


    }
}
