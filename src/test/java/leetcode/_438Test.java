package leetcode;

import leetcode.slidingwindow._438_AllAnagrams_String_SlidingWindow;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
@Ignore
public class _438Test {
    private static _438_AllAnagrams_String_SlidingWindow solution1;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _438_AllAnagrams_String_SlidingWindow();
    }

    @Test
    public void test1() {
        int arr[] = {1,2,3};
        List<Integer> result = solution1.findAnagrams2("abcd", "ba");
        assertEquals(1, result.size());
        System.out.println(result);
    }

    @Test
    public void test2() {
        int arr[] = {1,2,3};
        List<Integer> result = solution1.findAnagrams2("abab", "ba");
        assertEquals(3, result.size());
        System.out.println(result);
    }

    @Test
    public void test3() {
        int arr[] = {1,2,3};
        List<Integer> result = solution1.findAnagrams2("cbaebabacd", "abc");
        assertEquals(2, result.size());
        System.out.println(result);
    }
}