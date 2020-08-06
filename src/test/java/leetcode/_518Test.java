package leetcode;

import leetcode.backtracking.SubsetsGenericBacktrack;
import leetcode.backtracking._39_CombinationSum_DFS;
import leetcode.backtracking._40_CombinationSum2_Duplicates_DFS;
import leetcode.dfs._518_CoinChange2;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class _518Test {
    private static _518_CoinChange2 solution1;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _518_CoinChange2();
    }

    @Test
    public void test1() {
        int arr[] = {1,2, 5};
        int result = solution1.change(5, arr );
        String s;

        assertEquals(4, result);
        System.out.println(result);
    }
}