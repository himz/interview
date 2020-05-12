package leetcode;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class _26Test {
    private static _26 solution1;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _26();
    }

    @Test
    public void test1() {
        assertEquals(5, solution1.removeDuplicates(new int[]{1,1,1,1,2,2,2,2,3,4,5,5}));
    }

    @Test
    public void test2() {
        assertEquals(0, solution1.removeDuplicates(new int[]{}));
    }
    @Test
    public void test3() {
        assertEquals(1, solution1.removeDuplicates(new int[]{1}));
    }
    @Test
    public void test4() {
        assertEquals(2, solution1.removeDuplicates(new int[]{1,2}));
    }

}