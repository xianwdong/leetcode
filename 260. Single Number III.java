/*Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once.
For example:
Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
Note:
    1. The order of the result is not important. So in the above example, [5, 3] is also correct.
    2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?*/


因为将所有数异或得到的结果是两个不同的数异或的结果a ^ b
因为a != b， 所以a ^ b != 0， 假设a和b从低到高第3位不想等， 我们可以构造100， 通过 & 操作
将数组分为两个部分， 一部分 & 100 = 0， 另一部分 & 100 != 0

public int getBitDiff(int n) {
    int result = 1;
    while ((n & result) == 0) {
        result <<= 1;
    }
    return result;
}

public int[] singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; ++i) {
        result ^= nums[i];
    }
    int temp = getBitDiff(result);
    int[] arr = {
        0,
        0
    };
    for (int i = 0; i < nums.length; ++i) {
        if ((nums[i] & temp) == 0) {
            arr[0] ^= nums[i];
        } else {
            arr[1] ^= nums[i];
        }
    }
    return arr;
}