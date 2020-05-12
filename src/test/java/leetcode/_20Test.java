package leetcode;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class _20Test {
    private static _20 solution1;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _20();
    }

    @Test
    public void test1() {
        assertEquals(false, solution1.isValid("(]"));
    }

    @Test
    public void test2() {
        assertEquals(false, solution1.isValid("([)]"));
    }

    @Test
    public void test3() {
        assertEquals(true, solution1.isValid("()[]{}"));
    }

    @Test
    public void test4() {
        assertEquals(true, solution1.isValid("()"));
    }

    @Test
    public void test5() {
        assertEquals(false, solution1.isValid("("));
    }

    @Test
    public void test6() {
        assertEquals(false, solution1.isValid(")"));
    }

    @Test
    public void test7() {
        assertEquals(true, solution1.isValid(""));
    }
}