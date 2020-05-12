package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

// Level Order traversal with each level separated
public class _637_LevelTraversalAvd {

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();

        q.offer(root);

        while (!q.isEmpty()) {

            int n = q.size();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode tmp = q.poll();
                sum = sum + tmp.val;

                if (tmp != null) {
                    if (tmp.left != null)
                        q.offer(tmp.left);
                    if (tmp.right != null)
                        q.offer(tmp.right);
                }
            }
            res.add(sum / n);
        }
        return res;
    }
}
