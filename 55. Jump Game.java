/*Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.*/

For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.

// 基于一个事实，如果能到达i，那么一定能到达i - 1
public static boolean canJump(int[] nums) {
    // reach表示如果能跳到在i处能跳到的最远位置
    int i = 0, reach = 0;
    for (; i < nums.length && i <= reach; ++i) {
        reach = Math.max(reach, i + nums[i]);
    }
    // 如果是因为i > reach退出，说明最远位置无法到达i
    return i == nums.length;
}
public static boolean canJump(int[] nums) {
    int last = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; --i) {
        // 如果位置A能到最后一个位置，则更新最后一个位置为A
        if (i + nums[i] >= last) {
            last = i;
        }
    }
    return last == 0;
}