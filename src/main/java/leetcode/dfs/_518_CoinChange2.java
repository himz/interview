package leetcode.dfs;

import java.lang.reflect.Array;
import java.util.*;

public class _518_CoinChange2 {
    /** Solution 1 - backtracking!
     */
    public int change(int amount, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(coins);
        dfs(coins, result, amount, new ArrayList<>(), 0, 0);
        return result.size();
    }



    void dfs(int[] coins, List<List<Integer>> result, int amount, List<Integer> tmpList, int sum, int start) {

        if(amount == sum) {
            result.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i = start; i < coins.length; i++) {

            if(sum + coins[i] > amount) {
                continue;
            }
            sum = sum + coins[i];
            tmpList.add(coins[i]);
            dfs(coins, result, amount, tmpList, sum, i);
            tmpList.remove(tmpList.size() - 1);
            sum = sum - coins[i];
        }
    }
}
