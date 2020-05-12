package leetcode.tree;

import java.util.Arrays;

import common.TreeNode;

public class _538_BstToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        convert(root, 0);
        return root;
    }

    public int convert(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        sum = convert(root.right, sum);
        sum = root.val + sum;
        root.val = sum;
        sum = convert(root.left, sum);
        return sum;
    }
}
