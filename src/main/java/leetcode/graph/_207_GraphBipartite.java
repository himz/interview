package leetcode.graph;

/**
 * 785. Is Graph Bipartite?
 * Medium
 *
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A and B, such that every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 *
 *
 *
 * Example 1:
 *
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.
 *
 * Example 2:
 *
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: We cannot find a way to divide the set of nodes into two independent subsets.
 *
 *
 *
 * Constraints:
 *
 *     1 <= graph.length <= 100
 *     0 <= graph[i].length < 100
 *     0 <= graph[i][j] <= graph.length - 1
 *     graph[i][j] != i
 *     All the values of graph[i] are unique.
 *     The graph is guaranteed to be undirected.
 *
 * https://leetcode.com/problems/is-graph-bipartite/
 */

import java.util.*;

/**
 * Graph Bipartite Algo. Color Graph, two colors - red/black. if no ambiguity, bipartite.
 */
public class _207_GraphBipartite {
    public boolean isBipartite(int[][] graph) {
        // create a graph out of the given nodes
        // bipartite algo
        int []visited = new int[graph.length];
        Arrays.fill(visited, -1); // 0 = red, 1 == blue

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < graph.length; i++) {
            if(visited[i] >=0) {
                // TO handle multi COmponent case.
                // already visited, continue;
                continue;
            }
            queue.push(i);

            while(!queue.isEmpty()) {
                int  v = queue.poll();
                if(visited[v] == -1) {
                    // mark it with some color
                    visited[v] = 0;
                }
                for(int w : graph[v]) {

                    if(visited[w] == -1) {
                        // mark it with some color
                        visited[w] = 1 - visited[v];
                        queue.offer(w);
                    } else {
                        // if already colored, check the color to not match parent
                        if(visited[v] == visited[w]) {
                            // bad!
                            return false;
                        }
                    }

                }
            }
        }

        return true;
    }
}
