/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
[ 1, 2, 3 ],
[ 4, 5, 6 ],
[ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/

public List < Integer > spiralOrder(int[][] matrix) {
    List < Integer > result = new ArrayList < > ();
    if (matrix == null || matrix.length == 0) {
        return result;
    }
    int row = matrix.length, col = matrix[0].length;
    int curRow = 0, curCol = 0;
    while (result.size() != row * col) {
        for (int j = curCol; j < col - curCol; ++j) {
            result.add(matrix[curRow][j]);
        }
        for (int i = curRow + 1; i < row - curRow; ++i) {
            result.add(matrix[i][col - curCol - 1]);
        }
        for (int j = col - curCol - 2; j >= curCol && (row - curRow - 1) != curRow; --j) {
            result.add(matrix[row - curRow - 1][j]);
        }
        for (int i = row - curRow - 2; i >= curRow + 1 && (col - curCol - 1) != curCol; --i) {
            result.add(matrix[i][curCol]);
        }
        curRow++;
        curCol++;
    }
    return result;
}