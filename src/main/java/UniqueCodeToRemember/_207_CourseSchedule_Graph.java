package UniqueCodeToRemember;

/**
 * 207. Course Schedule
 * Medium
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 *
 *
 * Constraints:
 *
 *     The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 *     You may assume that there are no duplicate edges in the input prerequisites.
 *     1 <= numCourses <= 10^5
 *
 * https://leetcode.com/problems/course-schedule/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Good template for Graph DFS. Also has steps for optimization.
 */
public class _207_CourseSchedule_Graph {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // as num of courses is high, will have to use adjacency list, cannot use matrix.
        // List of next courses
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

        // Build the graph
        for(int[] relation : prerequisites) {
            if(courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }

        // Graph is ready, dfs it
        int []visited = new int[numCourses];  //0 - not processed; 1 - processing, 2 - processed. -- // optimization to avoid going into unncessary cycles.
        Arrays.fill(visited, 0);
        boolean ret = false;
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] != 2) {
                ret = dfs(i, courseDict, visited);
                if(ret) {
                    return false;
                }
            }
        }
        return true;
    }


    boolean dfs(Integer currCourse, HashMap<Integer, List<Integer>> courseDict, int[] visited) {
        if(visited[currCourse] == 1) {
            // cycle detected
            return true;
        }
        // handle case for when a course has no pre req -- disconnected node of graph
        if(!courseDict.containsKey(currCourse)) {
            return false;
        }

        visited[currCourse] = 1;

        boolean ret = false;
        for(Integer nextCourse : courseDict.get(currCourse)) {
            ret = dfs(nextCourse, courseDict, visited);
            if(ret) {
                break;
            }
        }

        // After backtracking, remove the node from the path -- Important step for DFS. visited[curr] = false
        visited[currCourse] = 2;
        return ret;


    }
}
