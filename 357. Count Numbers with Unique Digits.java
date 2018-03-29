/*Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, 
excluding [11,22,33,44,55,66,77,88,99])*/

public int countNumbersWithUniqueDigits(int n) {
    int[] dp = new int[11];
    dp[0] = 1;
    for (int i = 1; i <= 10; ++i) {
        int cnt = 1;
        for (int j = 1; j < i; ++j) {
            cnt *= (10 - j);
        }
        dp[i] = cnt * 9 + dp[i - 1];
    }
    return n <= 10 ? dp[n] : dp[10];
}