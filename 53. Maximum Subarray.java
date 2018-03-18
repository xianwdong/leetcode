/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.*/

public int maxSubArray(int[] nums) {
    int curSum = 0, maxSofar = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; ++i) {
        curSum += nums[i];
        maxSofar = Math.max(curSum, maxSofar);
        curSum = Math.max(0, curSum);
    }
    return maxSofar;
}