package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Level order traversal
public class _102_LOT1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList();
        List<Integer> tempList;
        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = q.poll();
                tempList.add(tmp.val);
                if (tmp != null) {
                    if (tmp.left != null)
                        q.offer(tmp.left);
                    if (tmp.right != null)
                        q.offer(tmp.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}
