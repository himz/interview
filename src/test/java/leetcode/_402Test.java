package leetcode;

import common.TreeNode;
import leetcode.greedy._402_RemoveKDigits;
import leetcode.searching._540_SingleElementArray_BinarySearch;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class _402Test {
    private static _402_RemoveKDigits solution1;
    private static TreeNode root;

    @BeforeClass
    public static void setup() {
        solution1 = new _402_RemoveKDigits();
    }

    @Test
    public void test1() {
        String nums = "1432219";
        int remove = 3;
        String solution = "1219";
        assertEquals(solution, solution1.removeKdigits(nums, remove));
    }

    @Test
    public void test2() {
        String nums = "10200";int remove = 1;
        String solution = "200";
        assertEquals(solution, solution1.removeKdigits(nums, remove));
    }

    @Test
    public void test3() {
        String nums = "10";
        int remove = 2;
        String solution = "0";
        assertEquals(solution, solution1.removeKdigits(nums, remove));
    }

    @Test
    public void test4() {
        String nums = "1431219";
        int remove = 3;
        String solution = "1119";
        assertEquals(solution, solution1.removeKdigits(nums, remove));
    }

    @Test
    public void test5() {
        String nums = "112";
        int remove = 1;
        String solution = "11";
        assertEquals(solution, solution1.removeKdigits(nums, remove));
    }

    @Test
    public void test6() {
        String nums = "1234567890";
        int remove = 9;
        String solution = "0";
        assertEquals(solution, solution1.removeKdigits(nums, remove));
    }

    @Test
    public void test7() {
        String nums = "1111";
        int remove = 3;
        String solution = "1";
        assertEquals(solution, solution1.removeKdigits(nums, remove));
    }

    @Test
    public void test8() {
        String nums = "1111";
        int remove = 4;
        String solution = "0";
        assertEquals(solution, solution1.removeKdigits(nums, remove));
    }

}