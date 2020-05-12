package leetcode;

import leetcode.dfs._200_NumberOfIslands_DFS;
import leetcode.unionfind._200_NumberOfIslands_UnionFind;
import org.junit.BeforeClass;
import org.junit.Test;import static org.junit.Assert.assertEquals;

public class _200Test {
    private static _200_NumberOfIslands_UnionFind solution1;
    private static _200_NumberOfIslands_DFS solution2;
    private static String[] A;

    @BeforeClass
    public static void setup() {
        solution1 = new _200_NumberOfIslands_UnionFind();
        solution2 = new _200_NumberOfIslands_DFS();
    }

    @Test
    public void test1() {
        char[][] arr = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int val = solution1.numIslands(arr);
        System.out.println(val);
        assertEquals(val,1);
    }

    @Test
    public void test2() {
        char[][] arr = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int val = solution1.numIslands(arr);
        System.out.println(val);
        assertEquals(val,3);
    }

    @Test
    public void test3() {

        char[][] arr = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int val = solution2.numIslands(arr);
        System.out.println(val);
        assertEquals(3,val);
    }

    @Test
    public void test4() {
        char[][] arr = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int val = solution2.numIslands(arr);
        System.out.println(val);
        assertEquals(1,val);
    }

}