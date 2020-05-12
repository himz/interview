package leetcode;

import leetcode.backtracking.SubsetsGenericBacktrack;
import leetcode.backtracking._46_Permutations_Backtrack;
import leetcode.backtracking._47_Permutations_Unique_Backtrack;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class _46Test {
    private static _46_Permutations_Backtrack solution1;
    private static _47_Permutations_Unique_Backtrack solution2;
    private static SubsetsGenericBacktrack solution3;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _46_Permutations_Backtrack();
        solution2 = new _47_Permutations_Unique_Backtrack();
        solution3 = new SubsetsGenericBacktrack();
    }

    @Test
    public void test1() {
        int arr[] = {1,2,3,};
        List<List<Integer>> result = solution1.permute(arr);

        System.out.println(result);
    }

    @Test
    public void test2() {
        int arr[] = {1,1,3,};
        List<List<Integer>> result = solution2.permuteUnique(arr);

        System.out.println(result);
    }

    @Test
    public void test3() {
        int arr[] = {1,2,3};
        List<List<Integer>> result = solution3.subsets(arr);

        System.out.println(result);
    }
}