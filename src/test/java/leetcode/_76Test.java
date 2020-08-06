package leetcode;

import leetcode.slidingwindow._438_AllAnagrams_String_SlidingWindow;
import leetcode.slidingwindow._76_MinimumWindowSubstring;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class _76Test {
    private static _76_MinimumWindowSubstring solution1;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _76_MinimumWindowSubstring();
    }

    @Test
    public void test1() {
        int arr[] = {1,2,3};
        String result = solution1.minWindow("ADOBECODEBANC", "ABC");
        assertEquals(4, result.length());
        System.out.println(result);
    }

   @Test
    public void test2() {
        int arr[] = {1,2,3};
        String result = solution1.minWindow("a", "b");
        assertEquals(0, result.length());
        System.out.println(result);
    }
/*
    @Test
    public void test3() {
        int arr[] = {1,2,3};
        String result = solution1.minWindow("cbaebabacd", "abc");
        assertEquals(2, result.size());
        System.out.println(result);
    }*/
}