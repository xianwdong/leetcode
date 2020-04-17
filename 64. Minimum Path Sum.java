// Given a m x n grid filled with non-negative numbers, 
// find a path from top left to bottom right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

// Example:
// Input:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.

public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
        return 0;
    }
    int row = grid.length;
    int column = grid[0].length;
    int[] dp = new int[column];
    for (int i = 0; i < row; ++i) {
        for (int j = 0; j < column; ++j) {
            if (i == 0 && j == 0) {
                dp[j] = grid[i][j];
            } else if (i == 0) {
                dp[j] = dp[j - 1] + grid[i][j];
            } else if (j == 0) {
                dp[j] = dp[j] + grid[i][j];
            } else {
                dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
            }
        }
    }
    return dp[column - 1];
}