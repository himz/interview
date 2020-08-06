package leetcode;

import leetcode.string._171_ExcelSheetNumber;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class _171Test {
    private static _171_ExcelSheetNumber solution1;//

    @BeforeClass
    public static void setup() {
        solution1 = new _171_ExcelSheetNumber();
    }

    @Test
    public void test1() {
        int arr[] = {1,2,3};
        int result = solution1.titleToNumber("AB");

        System.out.println(result);
    }
}