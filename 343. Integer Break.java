// Given a positive integer n, break it into the sum of at least two positive integers and
// maximize the product of those integers. Return the maximum product you can get.
// For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
// Note: You may assume that n is not less than 2 and not larger than 58.

// 把一个数拆成3和2，乘积最大
public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[2] = 1;
    for (int i = 3; i <= n; ++i) {
        int curMax = (i / 2) * (i - i / 2);
        for (int j = 2; j < i; ++j) {
            curMax = Math.max(curMax, dp[j] * (i - j));
        }
        dp[i] = curMax;
    }
    return dp[n];
}

public int integerBreak(int n) {
    if (n == 2) {
        return 1;
    }
    if (n == 3) {
        return 2;
    }
    int product = 1;
    while (n > 4) {
        product *= 3;
        n -= 3;
    }
    product *= n;
    return product;
}