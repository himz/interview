package leetcode;

import leetcode.dp._213_HouseRobber2;
import leetcode.dp._62_UniquePaths;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class _213Test {
    private static _213_HouseRobber2 solution1;//

    @BeforeClass
    public static void setup() {
        solution1 = new _213_HouseRobber2();
    }

    @Test
    public void test1() {
        int arr[] = {1,2,3,1};
        int result = solution1.rob(arr);

        Assert.assertEquals(3, result);
    }

}
