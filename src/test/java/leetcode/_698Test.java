package leetcode;

import leetcode.backtracking._698_PartitionKEqualSubsetSum;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class _698Test {
    private static _698_PartitionKEqualSubsetSum solution1;

    @BeforeClass
    public static void setup() {
        solution1 = new _698_PartitionKEqualSubsetSum();
    }

    @Test
    public void test1() {
        int arr[] = {4, 3, 2, 3, 5, 2, 1};
        boolean result = solution1.canPartitionKSubsets(arr, 4);
        System.out.println(result);
    }
}