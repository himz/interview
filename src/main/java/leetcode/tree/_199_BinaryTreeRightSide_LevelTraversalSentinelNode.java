package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * Medium
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 *   https://leetcode.com/problems/binary-tree-right-side-view/
 */
// Level Order traversal with each level separated.
// COncept: Using Sentinel Node to differentiate b/w two queues. Way more efficient than two queues.
public class _199_BinaryTreeRightSide_LevelTraversalSentinelNode {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;
        // level order traversal, right to left
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        TreeNode prev, curr = root;
        while(!q.isEmpty()) {
            prev = curr;
            curr = q.poll();
            boolean flag = true;
            while(curr != null) {

                if(flag) {
                    flag = false;
                    result.add(curr.val);
                }
                if(curr.right!= null)
                    q.offer(curr.right);
                if(curr.left != null)
                    q.offer(curr.left);
                prev = curr;
                curr = q.poll();
            }

            if(!q.isEmpty())
                q.offer(null);

        }

        return result;
    }
}
