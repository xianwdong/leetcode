/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
For example,
Given n = 3,
You should return the following matrix:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]
*/

public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int curRow = 0, curCol = 0;
    int index = 1;
    while (index != n * n + 1) {
        for (int j = curCol; j < n - curCol; ++j) {
            matrix[curRow][j] = index++;
        }
        for (int i = curRow + 1; i < n - curRow; ++i) {
            matrix[i][n - curCol - 1] = index++;
        }
        for (int j = n - curCol - 2; j >= curCol && (n - curRow - 1) != curRow; --j) {
            matrix[n - curRow - 1][j] = index++;
        }
        for (int i = n - curRow - 2; i >= curRow + 1 && (n - curCol - 1) != curCol; --i) {
            matrix[i][curCol] = index++;
        }
        curRow++;
        curCol++;
    }
    return matrix;
}