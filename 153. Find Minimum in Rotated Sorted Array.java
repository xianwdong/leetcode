// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

// Find the minimum element.
// You may assume no duplicate exists in the array.

// Example 1:
// Input: [3,4,5,1,2] 
// Output: 1

// Example 2:
// Input: [4,5,6,7,0,1,2]
// Output: 0

public int findMin(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start < end) {
        // 如果nums[start] < nums[end]，说明这个区间里就是有序的，nums[start]就是最小值
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        // nums[mid] >= nums[start]说明最小值肯定在mid的右边
        if (nums[mid] >= nums[start]) {
            start = mid + 1;
        } else {
            end = mid;
        }
    }
    return nums[start];
}