package leetcode;

import leetcode.searching._278_FirstBadVersion_BinarySearch;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class _278Test {
    private static _278_FirstBadVersion_BinarySearch solution1;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _278_FirstBadVersion_BinarySearch();
    }

    @Test
    public void test1() {
        assertEquals(1702766719, solution1.firstBadVersion(2126753390));
    }
}