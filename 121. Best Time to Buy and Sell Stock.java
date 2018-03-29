/*Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5
max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0
In this case, no transaction is done, i.e. max profit = 0.*/

ps：这题提供了一种思路
对于数组[7, 1, 5, 3, 6, 4]，可以转化成[0, -6, 4, -2, 3, -2]，然后求最大连续子数组和

public int maxProfit(int[] prices) {
    int maxCur = 0, maxSofar = 0;
    for (int i = 1; i < prices.length; ++i) {
        maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
        maxSofar = Math.max(maxSofar, maxCur);
    }
    return maxSofar;
}