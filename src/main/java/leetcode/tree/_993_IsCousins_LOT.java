package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * Validate Binary Search Tree
 */
public class _993_IsCousins_LOT {
    public boolean isCousins(TreeNode root, int x, int y) {

        LinkedList<TreeNode> q = new LinkedList<TreeNode>() ;

        q.offer(root);

        TreeNode parentX = null;
        TreeNode parentY = null;
        while(!q.isEmpty()) {


            int size = q.size();
            TreeNode tmp = null;
            for(int i = 0; i < size; i++) {
                tmp = q.poll();

                if(tmp.left != null) {
                    q.offer(tmp.left);
                    if(tmp.left.val == x) {
                        parentX = tmp;
                    } else if(tmp.left.val == y) {
                        parentY = tmp;
                    }
                }
                if(tmp.right != null) {
                    q.offer(tmp.right);
                    if(tmp.right.val == x) {
                        parentX = tmp;
                    } else if(tmp.right.val == y) {
                        parentY = tmp;
                    }
                }
            }

            if(parentX != null && parentY != null && parentX != parentY) {
                return true;
            }
        }

        return false;

    }
}