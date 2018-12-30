/*Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list, 
nd each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.*/

public int[] plusOne(int[] digits) {
    int carry = 1;
    int temp;
    for (int i = digits.length - 1; i >= 0; --i) {
        temp = digits[i];
        digits[i] = (digits[i] + carry) % 10;
        carry = (temp + carry) / 10;
    }
    if (carry != 1) {
        return digits;
    }
    int[] newArray = new int[digits.length + 1];
    newArray[0] = 1;
    System.arraycopy(digits, 0, newArray, 1, digits.length);
    return newArray;
}