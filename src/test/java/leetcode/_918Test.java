package leetcode;

import leetcode.dp._918_MaxSubCircularArray;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class _918Test {
    private static _918_MaxSubCircularArray solution1;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _918_MaxSubCircularArray();
    }

    @Test
    public void test1() {
        assertEquals(3, solution1.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    }

    @Test
    public void test2() {
        assertEquals(10, solution1.maxSubarraySumCircular(new int[]{5,-3,5}));
    }

    @Test
    public void test3() {
        assertEquals(4, solution1.maxSubarraySumCircular(new int[]{3,-1,2,-1}));
    }

    @Test
    public void test4() {
        assertEquals(3, solution1.maxSubarraySumCircular(new int[]{3,-2,2,-3}));
    }


    @Test
    public void test5() {
        assertEquals(19, solution1.maxSubarraySumCircular(new int[]{2,-2,2,7,8,0}));
    }
    @Test
    public void test6() {
        assertEquals(16, solution1.maxSubarraySumCircular(new int[]{0,5,8,-9,9,-7,3,-2}));
    }


}