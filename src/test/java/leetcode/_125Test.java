package leetcode;

import leetcode.string._125_ValidPalindrome;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class _125Test {
    private static _125_ValidPalindrome solution1;//

    @BeforeClass
    public static void setup() {
        solution1 = new _125_ValidPalindrome();
    }

    @Test
    public void test1() {
        int arr[] = {1,2,3};
        boolean result = solution1.isPalindrome("A man, a plan, a canal: Panama");

        Assert.assertTrue(result);
    }
    @Test
    public void test2() {
        int arr[] = {1,2,3};
        boolean result = solution1.isPalindrome(",+");

        Assert.assertTrue(result);
    }
    @Test
    public void test3() {
        int arr[] = {1,2,3};
        boolean result = solution1.isPalindrome("Madam");

        Assert.assertTrue(result);
    }
    @Test
    public void test4() {
        int arr[] = {1,2,3};
        boolean result = solution1.isPalindrome("maddam");

        Assert.assertTrue(result);
    }

    @Test
    public void test5() {
        int arr[] = {1,2,3};
        boolean result = solution1.isPalindrome(",,,,,,,,,,,,acva");

        Assert.assertFalse(result);
    }
}
