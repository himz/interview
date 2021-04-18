package leetcode.dfsbfs;

import java.util.ArrayDeque;

/**
 * 934. Shortest Bridge
 * Medium
 *
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 *
 *
 *
 * Example 1:
 *
 * Input: A = [[0,1],[1,0]]
 * Output: 1
 *
 * Example 2:
 *
 * Input: A = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 *
 * Example 3:
 *
 * Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *     2 <= A.length == A[0].length <= 100
 *     A[i][j] == 0 or A[i][j] == 1
 * https://leetcode.com/problems/shortest-bridge/
 */


/**
 * Very nice question
 * - Idea - DFS to mark first island visited(2)
 * - BFS to expand the island, till we get to next island.
 */
public class _934_ShortestBridge {
    int m, n;
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] arr) {
        if(arr == null || arr.length ==0)
            return -1;
        m = arr.length;
        n = arr[0].length;
        boolean found = false;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    // mark the complete island
                    dfs(arr, i, j,q);
                    found = true;
                    break;
                }
            }

            if(found)
                break;
        }

        int prev = 2;
        // expand the island; BFS
        int curr = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            curr = prev + 1;
            for(int i = 0; i < size ; i++) {
                int [] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int j = 0; j < 4; j++) {
                    int nx = x + dir[j][0];
                    int ny = y + dir[j][1];
                    if(!isValid(nx,ny))
                        continue;
                    if(arr[nx][ny] == prev) {
                        // already part of island
                        continue;
                    } else if(arr[nx][ny] == 0) {
                        // add to the values
                        arr[nx][ny] = curr;
                        q.offer(new int[] {nx, ny});
                    } else if(arr[nx][ny] == 1) {
                        // new island found.
                        return prev - 2;
                    }
                }
            }
            prev = curr;



        }

        return -1;



    }



    void dfs(int [][] arr, int x, int y, ArrayDeque<int[]> q) {
        // mark the place as visited
        arr[x][y] = 2;
        q.offer(new int[] {x, y}); // add to initial q


        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(isValid(nx, ny) && arr[nx][ny] == 1) {
                // visit
                dfs(arr, nx, ny, q);
            }
        }

    }


    boolean isValid(int x, int y) {
        if(x >= 0 && x < m && y >= 0 && y < n)
            return true;
        return false;
    }



}
