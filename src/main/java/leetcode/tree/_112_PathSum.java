package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * https://leetcode.com/problems/path-sum/
 * Similar: https://leetcode.com/problems/path-sum-ii/, https://leetcode.com/problems/path-sum-iii/
 */
public class _112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        return dfs(root, sum, 0, false);

    }


    public boolean dfs(TreeNode root, int sum, int cSum, boolean flag) {

        if(flag == true) {
            return true;
        }

        if(root == null) {
            return false;
        }


        // If leaf node
        if(root.left == null && root.right == null) {
            if(sum == cSum + root.val) {
                // Sum found
                flag = true;
                return true;
            }
        }

        // Iterate
        flag = dfs(root.left, sum, cSum + root.val, flag);
        flag = dfs(root.right, sum, cSum + root.val, flag);

        return flag;
    }
}