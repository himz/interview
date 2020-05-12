package leetcode.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import common.TreeNode;

public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode a, TreeNode b) {
        if(a == null && b == null) {
            return true;
        } else if (b == null || a == null) {
            return false;
        }

        if(a.val != b.val) {
            return false;
        }

        boolean flag1 = isSymmetricHelper(a.left, b.right);
        boolean flag2 = isSymmetricHelper(a.right, b.left);

        return flag1&flag2;
    }

    public boolean isSymmetricDfs(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

    public boolean isSymmetricBfs(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList();

        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null ||left.val != right.val )
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

        }
        return true;

    }
}
