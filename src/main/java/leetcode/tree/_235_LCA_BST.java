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
public class _235_LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        TreeNode p1, q1;
        if(p.val <= q.val){
            p1 = p;
            q1 = q;
        } else {
            p1 = q;
            q1 = p;
        }
        TreeNode node = lcaBst(root, p1,q1);
        return node;

    }
    // BST LCA
    public TreeNode lcaBst(TreeNode root, TreeNode p, TreeNode  q) {
        if(root == null) {
            return null;
        }
        // assuming p < q
        while(root != null) {
            if(root.val > p.val && root.val < q.val) {
                // root is the lca
                return root;
            } else if(root == p || root == q) {
                // root is the lca
                return root;
            } else if(root.val < p.val) {
                // lca is in right sub tree
                root = root.right;
            } else if(root.val > q.val) {
                // lca in left sub tree
                root = root.left;
            }
        }

        return null;

    }
}