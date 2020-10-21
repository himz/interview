package leetcode.dp;

import common.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * Hard
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3]
 * Output: 6
 *
 * Example 2:
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 3 * 104].
 *     -1000 <= Node.val <= 1000
 */
public class _124_MaxPathSum_TreeDp {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root == null) {
            return 0;
        }

        dfs(root);
        return res;

    }

    int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }


        int l = dfs(root.left);
        int r = dfs(root.right);

        int temp = Math.max( root.val + Math.max(l,r), root.val);

        int ans = Math.max(temp, root.val + l + r);

        res = Math.max(ans, res);

        return temp;
    }
}
