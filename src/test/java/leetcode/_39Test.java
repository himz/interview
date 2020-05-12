package leetcode;

import leetcode.backtracking.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore
public class _39Test {
    private static _39_CombinationSum_DFS solution1;
    private static _40_CombinationSum2_Duplicates_DFS solution2;
    private static SubsetsGenericBacktrack solution3;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _39_CombinationSum_DFS();
        solution2 = new _40_CombinationSum2_Duplicates_DFS();
        solution3 = new SubsetsGenericBacktrack();
    }

    @Test
    public void test1() {
        int arr[] = {2,3,5};
        List<List<Integer>> result = solution1.combinationSum(arr, 8 );

        System.out.println(result);
    }

    @Test
    public void test2() {
        int arr[] = {2,5,2,1,2};
        List<List<Integer>> result = solution2.combinationSum(arr, 5);

        System.out.println(result);
    }

    @Test
    public void test3() {
        int arr[] = {1,2,3};
        List<List<Integer>> result = solution3.subsets(arr);

        System.out.println(result);
    }
}