package leetcode;

import common.TreeNode;
import leetcode.dfsbfs._417_PacificAtlanticWater_flood;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class _417Test {
    private static _417_PacificAtlanticWater_flood solution1;
    private static TreeNode root;

    @BeforeClass
    public static void setup() {
        solution1 = new _417_PacificAtlanticWater_flood();
    }

    @Test
    public void test1() {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,2,2,3,5};
        matrix[1] = new int[]{3,2,3,4,4};
        matrix[2] = new int[]{2,4,5,3,1};
        matrix[3] = new int[]{6,7,1,4,5};
        matrix[4] = new int[]{5,1,1,2,4};

        List<List<Integer>> result = solution1.pacificAtlantic(matrix);

        System.out.println(result);
    }

}