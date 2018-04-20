/*The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1 (0 0 0 1)
4 (0 1 0 0)
↑ ↑

The above arrows point to positions where the corresponding bits are different.*/

public int hammingDistance(int x, int y) {
    int z = x ^ y;
    int cnt = 0;
    while (z != 0) {
        z = z & (z - 1);
        ++cnt;
    }
    return cnt;
}