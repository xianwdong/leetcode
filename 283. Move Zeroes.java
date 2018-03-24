/*Given an array nums, write a function to move all 0's to the end of it while maintaining 
the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
    1. You must do this in-place without making a copy of the array.
    2. Minimize the total number of operations.*/


public void moveZeroes(int[] nums) {
    int index = 0;
    for (int i = 0; i < nums.length; ++i) {
        if (nums[i] != 0) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index++] = temp;
        }
    }
}
// triky codes
public static void moveZeroes(int[] nums) {
    int insertPos = 0;
    for (int val: nums) {
        if (val != 0) {
            nums[insertPos++] = val;
        }
    }
    for (; insertPos < nums.length; ++insertPos) {
        nums[insertPos] = 0;
    }
}