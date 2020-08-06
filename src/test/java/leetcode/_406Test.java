package leetcode;

import leetcode.backtracking.SubsetsGenericBacktrack;
import leetcode.backtracking._46_Permutations_Backtrack;
import leetcode.backtracking._47_Permutations_Unique_Backtrack;
import leetcode.misc._406_QueueReconstruction;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore
public class _406Test {
    private static _406_QueueReconstruction solution1;

    @BeforeClass
    public static void setup() {
        solution1 = new _406_QueueReconstruction();
    }

    @Test
    public void test1() {
        int arr[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = solution1.reconstructQueue(arr);

        System.out.println(result);
    }

}