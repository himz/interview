package leetcode;

import common.TreeNode;
import common.utils.TreeUtils;
import leetcode.tree._993_IsCousins_LOT;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@Ignore
public class _993Test {
    private static _993_IsCousins_LOT solution1;
    private static TreeNode root;

    @BeforeClass
    public static void setup() {
        solution1 = new _993_IsCousins_LOT();
    }

    @Test
    public void test1() {
        root = TreeUtils.constructBinaryTree(Arrays.asList(1, 2, 3, null, 4, null, 5));
        assertEquals(true, solution1.isCousins(root, 4, 5));
    }

}