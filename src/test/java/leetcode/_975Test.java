package leetcode;

import leetcode.heap.pq._451_SortCharByFrequency;
import leetcode.stack._975_OddEvenJump;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Ignore
public class _975Test {
    private static _975_OddEvenJump solution1;


    @BeforeClass
    public static void setup() {
        solution1 = new _975_OddEvenJump();

    }

    @Test
    public void test1() {
        int result = 0;//= solution1.oddEvenJumps(new int[] {2,3,1,1,4});
        int [] pair = new int[] {10,1};

        List<int[]> list = new ArrayList<>();

        pair = new int[] {12,3};
        list.add(pair);
        pair = new int[] {10,2};
        list.add(pair);
        pair = new int[] {9,5};
        list.add(pair);
        pair = new int[] {9,2};
        list.add(pair);

        Collections.sort(list, (a,b) -> {
            int x = Integer.compare(a[0], b[0]);
            return x!=0?x:Integer.compare(a[1], b[1]);
        });


        System.out.println(result);
    }
}