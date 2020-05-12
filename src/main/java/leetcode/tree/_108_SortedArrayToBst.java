package leetcode.tree;


import common.TreeNode;

public class _108_SortedArrayToBst {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length -1);



    }

    public TreeNode helper(int[]nums, int start, int last) {
        if(start > last) {
            return null;
        }
        int mid = (last + start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid+1, last);

        return node;
    }

    public static void main(String args[]) {
        _108_SortedArrayToBst st = new _108_SortedArrayToBst();
        int[] nums = {-10,-3,0,5,9};

        TreeNode node = st.sortedArrayToBST(nums);
        return;
    }
}
