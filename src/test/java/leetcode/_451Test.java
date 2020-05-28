package leetcode;

import leetcode.backtracking.SubsetsGenericBacktrack;
import leetcode.backtracking._46_Permutations_Backtrack;
import leetcode.backtracking._47_Permutations_Unique_Backtrack;
import leetcode.string._451_SortCharByFrequency;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore
public class _451Test {
    private static _451_SortCharByFrequency solution1;


    @BeforeClass
    public static void setup() {
        solution1 = new _451_SortCharByFrequency();

    }

    @Test
    public void test1() {
        String result = solution1.frequencySort("tree");

        System.out.println(result);
    }
}