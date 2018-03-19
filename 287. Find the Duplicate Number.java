/*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
find the duplicate one.
Note:
    1. You must not modify the array (assume the array is read only).
    2. You must use only constant, O(1) extra space.
    3. Your runtime complexity should be less than O(n2).
    4. There is only one duplicate number in the array, but it could be repeated more than once.*/

使用快慢指针的思想，慢指针每次移动一个，快指针每次移动两个，则快慢指针必然会在环内某一点相遇。下面证明从起点到环入口和相遇点到环入口的距离相等。
设起点到环入口点的距离为a，环入口到相遇点的距离是b，环周长为L。当慢指针和快指针相遇时，假设慢指针走了n步，则：
a + b = n
a + b + kL = 2n(k为快指针比慢指针多走的圈数)
则KL = a + b
a = KL - b = (K - 1)L + (L - b)
即从起点到环入口点的距离 = 在圈内循环k - 1次+相遇点到环入口点的距离

public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
