package leetcode.tree;

import common.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * https://leetcode.com/problems/path-sum-iii/
 * Similar: https://leetcode.com/problems/path-sum-ii/, https://leetcode.com/problems/path-sum/
 */
public class _437_PathSum3 {

    /**
     * This is tough question, and this is a brute for solution
     *
     * Algo: Either we select a node, or not. Calculate paths for all the three cases, and sum them up.
     *          - Write a helper function, that will find the sum from starting node, recursively. As soon as the sum
     *          is required is achieved, we add up the count. This method also takes care of the case, when the next nodes are -x and +x, the counter will increase.
     *
     * Note - Tougher one will be to return the list of nodes. That will become combinatorial question.
     *
     * Space Complexity - O(n)
     * Time Complexity - O(n^2) in worst case. O(nlogn) in best.
     */
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSumFrom(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int returnVal = 0;

        int left = pathSumFrom(root.left, sum - root.val);
        int right = pathSumFrom(root.right, sum - root.val);

        if(root.val == sum) {
            // its a match
            returnVal = 1;
        }
        return returnVal + left + right;
    }
}