package leetcode;

import leetcode.misc._448_FindDisappearedNumbers;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

@Ignore
public class _448Test {
    private static _448_FindDisappearedNumbers solution1;

    @BeforeClass
    public static void setup() {
        solution1 = new _448_FindDisappearedNumbers();
    }

    @Test
    public void test1() {
        int arr[] = {4,3,2,7,8,2,3,1};
        List<Integer> result = solution1.findDisappearedNumbers(arr);

        System.out.println(result);
    }

}