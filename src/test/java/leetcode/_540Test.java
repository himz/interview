package leetcode;

import common.TreeNode;
import common.utils.TreeUtils;
import leetcode.searching._540_SingleElementArray_BinarySearch;
import leetcode.tree._993_IsCousins_LOT;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@Ignore
public class _540Test {
    private static _540_SingleElementArray_BinarySearch solution1;
    private static TreeNode root;

    @BeforeClass
    public static void setup() {
        solution1 = new _540_SingleElementArray_BinarySearch();
    }

    @Test
    public void test1() {
        int [] nums = {1,1,2,3,3,4,4,5,5};
        assertEquals(2, solution1.singleNonDuplicate(nums));
    }

    @Test
    public void test2() {
        int [] nums = {1};
        assertEquals(1, solution1.singleNonDuplicate(nums));
    }

    @Test
    public void test3() {
        int [] nums = {3,3,7,7,10,11,11};
        assertEquals(10, solution1.singleNonDuplicate(nums));
    }

    @Test
    public void test4() {
        int [] nums = {0,1,1,2,2,5,5};
        assertEquals(0, solution1.singleNonDuplicate(nums));
    }

    @Test
    public void test5() {
        int [] nums = {0,0,1,1,2,2,5};
        assertEquals(5, solution1.singleNonDuplicate(nums));
    }

}