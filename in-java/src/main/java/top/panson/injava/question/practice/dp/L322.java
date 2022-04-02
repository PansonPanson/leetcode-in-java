package top.panson.injava.question.practice.dp;

import java.util.Arrays;

/**
 * @create 2022-04-02 15:43
 * @Author: Panson
 */
public class L322 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for(int i = 0; i <= amount; i++) {
                for(int coin : coins) {
                    if( i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i],  1 + dp[i - coin]);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}
