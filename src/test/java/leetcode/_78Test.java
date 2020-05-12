package leetcode;

import leetcode.backtracking._78_Subsets1_DFS_Backtracking;
import leetcode.backtracking._90_Subsets2_Duplicate_Backtracking;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore
public class _78Test {
    private static _78_Subsets1_DFS_Backtracking solution1;
    private static _90_Subsets2_Duplicate_Backtracking solution2;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _78_Subsets1_DFS_Backtracking();
        solution2 = new _90_Subsets2_Duplicate_Backtracking();
    }

    @Test
    public void test1() {
        int arr[] = {1,2,3};
        List<List<Integer>> result = solution1.subsets(arr);

        System.out.println(result);
    }

    @Test
    public void test2() {
        int arr[] = {1,2,2};
        List<List<Integer>> result = solution2.subsets(arr);

        System.out.println(result);
    }
}