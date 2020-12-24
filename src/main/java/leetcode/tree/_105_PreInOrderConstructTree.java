package leetcode.tree;

import common.TreeNode;

/**
 *Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Similar:
 */
public class _105_PreInOrderConstructTree {
    // Good algo, optimization to put inorder in hashmap for faster retrieval, to avoid looping
    // Algo : Preorder is always the root of node. find that node in inorder. Left of it is left subtree, right is rightsubtree
    //      : We get the size of the left/right sub tree. Use that on Preorder to get the next root of left and right subtree.
    //      : Keep repeating till u form the whole tree
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        }

        if(preorder.length != inorder.length) {
            return null;
        }

        return helper(preorder, inorder, 0, 0, preorder.length);
    }


    public TreeNode helper(int[] p, int[] in, int pp, int ins, int ine) {
        if(pp >= p.length || ine > p.length) {
            return null;
        }

        TreeNode node = null;
        //find pivot of p in inorder
        System.out.println("here1 " + pp + ins + ine);
        for(int j = ins; j < ine; j++) {
            if(in[j] == p[pp] ) {
                System.out.println("pivot found" + j + p[pp]);
                // this is the tree node. Create a node. To the left is the left sub tree, and righ tis right sub treee
                node = new TreeNode(p[pp]);
                int lSize = j - ins;
                int rSize = ine - j - 1;
                // new pivots are the first element in p in left subtree and right sub tree
                if(lSize > 0) {
                    node.left = helper(p, in, pp + 1, ins, j);
                }
                if(rSize > 0) {
                    node.right = helper(p, in, pp + 1 + lSize, j +1, ine);
                }
                System.out.println("here2 " + pp + ins + ine + "--" + j);
            }
        }

        return node;

    }

}