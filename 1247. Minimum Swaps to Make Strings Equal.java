/* You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. 
Your task is to make these two strings equal to each other. You can swap any two characters that belong to different 
strings, which means: swap s1[i] and s2[j].
Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.

Example 1:
Input: s1 = "xx", s2 = "yy"
Output: 1
Explanation: 
Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".

Example 2: 
Input: s1 = "xy", s2 = "yx"
Output: 2
Explanation: 
Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
Note that you can't swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap chars in different strings.

Example 3:
Input: s1 = "xx", s2 = "xy"
Output: -1

Example 4:
Input: s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
Output: 4
 
Constraints:
1 <= s1.length, s2.length <= 1000
s1, s2 only contain 'x' or 'y'. */

public int minimumSwap(String s1, String s2) {
	int x1 = 0;
	// 对应index，s1为x，s2为y
	int y1 = 0;
	// 对应index，s1为y，s2为x
	int x2 = 0;
	// 对应index，s2为x，s1为y
	int y2 = 0;
	// 对应index，s2为y，s2为x
	for (int i = 0; i < s1.length(); ++i) {
		if (s1.charAt(i) == s2.charAt(i)) {
			continue;
		}
		if (s1.charAt(i) == 'x') {
			x1++;
		} else {
			y1++;
		}
		if (s2.charAt(i) == 'x') {
			x2++;
		} else {
			y2++;
		}
	}
	if ((x1 + x2) % 2 == 1 || (y1 + y2) % 2 == 1) {
		return -1;
	}
	/**
         * 这里只有两种情况, 要不x1 y1同为偶数, 要不x1 y1同为奇数
         * 如果x1 y1同为偶数, 那么x1 / 2相当于把xxxx yyyy这种两次交换完, y1/2同理
         * 如果x1 y1同为奇数, 那么x1 / 2交换完最后肯定还剩一个xy yx, 需要交换两次
         * */
	// return x1 / 2 + y1 / 2 + (x1 % 2) * 2
	return x1 / 2 + y1 / 2 + (y1 % 2) * 2;
}