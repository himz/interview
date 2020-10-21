package leetcode;

import leetcode.dfs._518_CoinChange2;
import leetcode.dp.kp._416_PartitionEqualSubsetSum;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class _416Test {
    private static _416_PartitionEqualSubsetSum solution1;


    @BeforeClass
    public static void setup() {
        solution1 = new _416_PartitionEqualSubsetSum();
    }

    @Test
    public void test1() {
            int arr[] = {1,7,4,5, 5};
        boolean result = solution1.canPartition(arr);
        System.out.println(result);
    }
}