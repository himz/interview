package leetcode;

import java.util.Arrays;

import leetcode.tree._104;
import org.junit.BeforeClass;
import org.junit.Test;

import common.TreeNode;
import common.utils.TreeUtils;

import static org.junit.Assert.assertEquals;

public class _104Test {
    private static _104 solution1;
    private static TreeNode root;

    @BeforeClass
    public static void setup() {
        solution1 = new _104();
    }

    @Test
    public void test1() {
        root = TreeUtils.constructBinaryTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        assertEquals(3, solution1.maxDepth(root));
    }

    @Test
    public void test2() {
        assertEquals(0, solution1.maxDepth(null));
    }
}