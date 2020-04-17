// Given an array of non-negative integers, you are initially positioned at the first index of the array.
// Each element in the array represents your maximum jump length at that position.
// Your goal is to reach the last index in the minimum number of jumps.

// Example:

// Input: [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2.
//     Jump 1 step from index 0 to 1, then 3 steps to the last index.

// 我用了额外的空间，并且时间复杂度比较高，不算好方法
public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length - 1; ++i) {
        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j < Math.min(i + nums[i] + 1, nums.length); ++j) {
            if (dp[j] == 0) {
                dp[j] = Math.min(min, dp[i] + 1);
            } else {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
    }
    return dp[nums.length - 1];
}

// 一个更好的方法，curFarthest代表了下一跳能跳的最远的地方
// curEnd代表每次跳的右边的边界，到达这个边界的时候，需要再跳一次，然后更新下一跳的右边界
public int jump(int[] A) {
	int jumps = 0, curEnd = 0, curFarthest = 0;
	for (int i = 0; i < A.length - 1; i++) {
		curFarthest = Math.max(curFarthest, i + A[i]);
		if (i == curEnd) {
			jumps++;
			curEnd = curFarthest;
		}
	}
	return jumps;
}