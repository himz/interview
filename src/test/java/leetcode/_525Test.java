package leetcode;

import leetcode.slidingwindow._525_ContiguousArray;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

@Ignore
public class _525Test {
    private static _525_ContiguousArray solution1;


    @BeforeClass
    public static void setup() {
        solution1 = new _525_ContiguousArray();

    }

    @Test
    public void test1() {
        int [] nums = {0,1};
        int result = solution1.findMaxLength(nums);
        assertEquals(2, result);

        System.out.println(result);
    }

    @Test
    public void test2() {
        int [] nums = {0,1,0,1,1,0,0,1,1,1};
        int result = solution1.findMaxLength(nums);
        assertEquals(8, result);
        System.out.println(result);
    }

    @Test
    public void test3() {
        int [] nums = {0,1,0,1,1,0,0,1,1};
        int result = solution1.findMaxLength(nums);
        assertEquals(3, result);
        System.out.println(result);
    }
}