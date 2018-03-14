// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. 
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// How many possible unique paths are there?

public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 0; i < m - 1; ++i) {
        for (int j = 1; j < n; ++j) {
            dp[j] = dp[j - 1] + dp[j];
        }
    }
    return dp[n - 1];
}