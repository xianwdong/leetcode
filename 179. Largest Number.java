Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:
Input: [10,2]
Output: "210"

Example 2:
Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

public String largestNumber(int[] nums) {
    String[] strings = new String[nums.length];
    for (int i = 0; i < nums.length; ++i) {
        strings[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strings, (str1, str2) -> {
        String s1 = str1 + str2;
        String s2 = str2 + str1;
        return s2.compareTo(s1);
    });
    // 注意输入是多个0的情况
    if (strings[0].charAt(0) == '0') {
        return "0";
    }
    StringBuilder result = new StringBuilder();
    for (String s : strings) {
        result.append(s);
    }
    return result.toString();
}