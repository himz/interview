package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 *     a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: root = []
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 5000].
 *     -104 <= Node.val <= 104
 * https://leetcode.com/problems/balanced-binary-tree/
 * Similar:
 */
public class _110_BalancedBinaryTreePair {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getValue();
    }

    // boolean/height
    Pair<Integer, Boolean>  dfs(TreeNode root) {


        if(root == null) {
            return new Pair<>(0, true);
        }

        // LRN iterate
        Pair<Integer, Boolean> l = dfs(root.left);
        Pair<Integer, Boolean> r = dfs(root.right);


        if(l.getValue() == false || r.getValue() == false) {
            return new Pair<>(-1, false);
        }
        int newHeight = l.getKey() > r.getKey() ? l.getKey() + 1: r.getKey() + 1;

        if(Math.abs(r.getKey() - l.getKey()) <= 1) {
            return new Pair<>(newHeight, true);
        } else {
            return new Pair<>(newHeight, false);
        }
    }

}

// Implementing own implementation of Pair class, as there is no such class available in java core in 12 version.
class Pair<T,R> {
    T key;
    R value;

    Pair(T key, R value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public R getValue() {
        return this.value;
    }
}