/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
For example,
Consider the following matrix:
[
[1, 3, 5, 7],
[10, 11, 16, 20],
[23, 30, 34, 50]
]
Given target = 3, return true.*/

public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length - 1, col = 0;
    while (row >= 0 && col < matrix[0].length) {
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] > target) {
            --row;
        } else {
            ++col;
        }
    }
    return false;
}