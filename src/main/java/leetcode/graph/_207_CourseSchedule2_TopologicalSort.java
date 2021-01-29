package leetcode.graph;

/**
 * 210. Course Schedule II
 * Medium
 *
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
 *
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 *
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 *
 * Constraints:
 *
 *     1 <= numCourses <= 2000
 *     0 <= prerequisites.length <= numCourses * (numCourses - 1)
 *     prerequisites[i].length == 2
 *     0 <= ai, bi < numCourses
 *     ai != bi
 *     All the pairs [ai, bi] are distinct.
 *
 * https://leetcode.com/problems/course-schedule-ii/
 */

import java.util.*;

/**
 * Topological Sort Algo
 */
public class _207_CourseSchedule2_TopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

        HashMap<Integer, Integer> indegree = new HashMap<>();
        for(int i = 0; i < numCourses;i++) {
            indegree.put(i, 0);
        }
        // Build the graph
        for(int[] relation : prerequisites) {
            if(courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }

            int tmp = indegree.get(relation[0]);
            indegree.put(relation[0], ++tmp);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Start with indegree == 0
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                // put it on stack to start with
                queue.offer(entry.getKey());
            }
        }

        int[] result = new int[numCourses];
        int count = 0;

        while(!queue.isEmpty()) {

            int v = queue.poll();
            result[count++] = v;

            List<Integer> child = courseDict.get(v);
            if(child!= null) {
                for(Integer w : child) {
                    // for each child, decrement in degree and then delete the node from course dict.

                    indegree.put(w, indegree.get(w) - 1);
                    if(indegree.get(w) == 0) {
                        queue.offer(w);
                    }
                }
            }
            courseDict.remove(v);


        }

        // check the result array, to be of the same size of that of the numCourses
        if(count == numCourses) {
            // we have a solution
            return result;
        } else {
            return new int[0];
        }



    }
}
