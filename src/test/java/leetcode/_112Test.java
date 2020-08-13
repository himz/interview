package leetcode;

import common.TreeNode;
import common.utils.TreeUtils;
import leetcode.tree._104;
import leetcode.tree._112_PathSum;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _112Test {
    private static _112_PathSum solution1;
    private static TreeNode root;

    @BeforeClass
    public static void setup() {
        solution1 = new _112_PathSum();
    }

    @Test
    public void test1() {
        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
        root = TreeUtils.constructBinaryTree(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1));
        boolean flag = solution1.hasPathSum(root, 22);
        assertEquals(flag, true);
    }

}