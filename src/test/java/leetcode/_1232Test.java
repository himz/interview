package leetcode;

import leetcode.math._1232_StraightLine;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class _1232Test {
    private static _1232_StraightLine solution1;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _1232_StraightLine();
    }

    @Test
    public void test1() {
        int arr[][] = {{1,1},{2,2},{3,3}};
        boolean result = solution1.checkStraightLine(arr);
        assertEquals(true, result);
        int arr1[][]= {{1,1},{2,2},{3,4}, {4,5}, {5,6}, {6,7}};
        result = solution1.checkStraightLine(arr1);
        assertEquals(false, result);

        int arr2[][] = {{4,8},{-2,8},{1,8}, {8,8}, {-5,8}, {0,8}, {7,8}, {5,8}};
        result = solution1.checkStraightLine(arr2);
        assertEquals(true, result);
        System.out.println(result);
    }
}