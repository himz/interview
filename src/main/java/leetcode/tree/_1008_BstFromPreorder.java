package leetcode.tree;

import common.TreeNode;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 *
 * Constraints:
 *
 *     1 <= preorder.length <= 100
 *     1 <= preorder[i] <= 10^8
 *     The values of preorder are distinct.
 *
 *     https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */

public class _1008_BstFromPreorder {
    /**
     * Algo: 1. As pre order is given, root is the first element.
     *       2. For BST, all elements on left should be lower, and right greater.
     *       3. So find the next bigger item than root.
     *       4. Recurse/Repeat. Same is valid for inorder too.
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }
        return bstHelper(preorder, 0, preorder.length -1);
    }


    TreeNode bstHelper(int[] arr, int left, int right) {
        if(left>right) {
            return null;
        }
        TreeNode root = new TreeNode(arr[left]);
        // Find left sub tree
        int i = 0;
        for(i = left+1; i <= right; i++) {
            if(arr[i] > arr[left]) {
                // this is where right subtree starts
                break;
            }
        }
        root.left = bstHelper(arr, left+1, i -1);
        root.right = bstHelper(arr, i, right);

        return root;

    }
}