package leetcode;

import leetcode.dp._62_UniquePaths;
import leetcode.string._125_ValidPalindrome;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class _62Test {
    private static _62_UniquePaths solution1;//

    @BeforeClass
    public static void setup() {
        solution1 = new _62_UniquePaths();
    }

    @Test
    public void test1() {
        int result = solution1.uniquePaths(3,2);

        Assert.assertEquals(3, result);
    }

}
