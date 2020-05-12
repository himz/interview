package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _771_JewelsStones {
    public int numJewelsInStones(String J, String S) {
        // Brute Force Solution

        // Hash Map Solution
        int counter = 0;
        Set<Character> jMap = new HashSet<>();
        for(Character tmp : J.toCharArray()) {
            jMap.add(tmp);
        }

        for(Character tmp : S.toCharArray()) {
            if(jMap.contains(tmp)) {
                counter++;
            }
        }
        return counter;
    }
}
