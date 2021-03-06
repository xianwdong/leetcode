/*You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public int climbStairs(int n) {
    int[] dp = {1, 2};
    for (int i = 3; i <= n; ++i) {
        dp[(i + 1) % 2] = dp[0] + dp[1];
    }
    return dp[(n + 1) % 2];
}