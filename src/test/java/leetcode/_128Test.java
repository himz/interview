package leetcode;

import leetcode.unionfind._128_LongestConsecutiveSequence_UnionFind;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _128Test {
    private static _128_LongestConsecutiveSequence_UnionFind solution1;

    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _128_LongestConsecutiveSequence_UnionFind();

    }

    @Test
    public void test1() {
        int[] arr = { 100, 4, 200, 1, 3, 2};
        int val = solution1.longestConsecutive(arr);
        System.out.println(val);
        assertEquals(val,4);
    }


}