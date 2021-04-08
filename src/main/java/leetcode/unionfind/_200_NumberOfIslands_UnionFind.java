package leetcode.unionfind;

import java.util.*;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 */
// Union Find Solution
public class _200_NumberOfIslands_UnionFind {

    int rows = 0;
    int cols = 0;
    public int numIslands(char[][] grid) {

        QuickUnionFind uf = new QuickUnionFind();
        rows = grid.length;
        cols = grid[0].length;
        uf.makeset(grid);
        for(int i = 0; i < rows; i++) {
            for(int j =0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    if (isLocValid(i, j+1) && grid[i][j + 1] == 1) {
                        uf.union(i*cols + j, i*cols + j + 1);
                    }

                    if (isLocValid(i+1, j) && grid[i+1][j] == 1) {
                        uf.union(i*cols + j, (i+1)*cols + j);
                    }
                }
            }
        }

        return uf.count;
    }

    private boolean isLocValid(int i, int j) {
        if(i >= rows || i < 0 || j >= cols || j < 0)
            return false;
        return true;
    }

    class QuickUnionFind {
        int[] parent;
        int count = 0;

        public void makeset(char grid[][]) {
           int  m = grid.length;
            int n = grid[0].length;
            parent = new int[m*n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int id = i * n + j;
                        parent[id] = id;
                        count++;
                    }
                }
            }

        }

        public void union(int node1, int node2) {
            int p1 = find(node1);
            int p2 = find(node2);

            if(p1 == p2)
                return;

            parent[p1]= p2;
            count--;
        }

        public int find(int node){
            if(node == parent[node])
                return node;
            return find(parent[node]);
        }
    }

}
