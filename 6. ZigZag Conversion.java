// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
// (you may want to display this pattern in a fixed font for better legibility)
// P A H N
// A P L S I I G
// Y I R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public String convert(String s, int numRows) {
    StringBuilder[] result = new StringBuilder[numRows];
    for (int i = 0; i < numRows; ++i) {
        result[i] = new StringBuilder("");
    }
    for (int i = 0; i < s.length(); ) {
        int row = 0;
        for (row = 0; row < numRows; ++row) {
            if (i < s.length()) {
                result[row].append(s.charAt(i++));
            }
        }
        for (row = row - 2; row > 0; --row) {
            if (i < s.length()) {
                result[row].append(s.charAt(i++));
            }
        }
    }
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < result.length; ++i) {
        sb.append(result[i]);
    }
    return sb.toString();
}