package leetcode.misc;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 *
 */
public class _406_QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        // Use insertion sort or priority queue
        int count=0;
        int [][] result = new int[people.length][2];
        result[0][0] = people[0][0];
        result[0][1] = people[0][1];


        for(int i = 0; i < result.length; i++) {
            result[i][0] = Integer.MAX_VALUE;
            result[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < people.length; i++) {
            int val = people[i][1];
            int val_bak = people[i][0];
            count++;
            for(int j = 0; j < count; j++) {
                if(val <= result[j][1]) {

                    if(val == result[j][1] && val_bak > result[j][0]) {
                        continue;
                    }
                    // insert at this location, move the current result next.
                    int temp_bak = result[j][0];
                    int temp = result[j][1];
                    result[j][1] = val;
                    result[j][0] = val_bak;

                    val = temp;
                    val_bak = temp_bak;

                }
            }
        }

        return result;


    }
}
