package leetcode;

import common.TreeNode;
import common.utils.TreeUtils;
import leetcode.tree._104;
import leetcode.tree._105_PreInOrderConstructTree;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _105Test {
    private static _105_PreInOrderConstructTree solution1;
    private static TreeNode root;

    @BeforeClass
    public static void setup() {
        solution1 = new _105_PreInOrderConstructTree();
    }

    @Test
    public void test1() {
        solution1.buildTree(new int[]{3, 9, 20, 15, 7},new int[]{9,3,15,20,7});
    }
}