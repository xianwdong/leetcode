// Given an encoded string, return its decoded string.
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
// being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
// Furthermore, you may assume that the original data does not contain any digits and that digits are only 
// for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

// Examples:
// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

// 注意一个坑是数字可能有多位
public String decodeString(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) != ']') {
            stack.push(s.charAt(i));
        } else {
            StringBuilder sb = new StringBuilder();
            char c;
            while ((c = stack.pop()) != '[') {
                sb.append(c);
                if (c == '[') {
                    break;
                }
            }
            sb.reverse();
            StringBuilder number = new StringBuilder();
            while (!stack.isEmpty() && Character.isDigit(c = stack.peek())) {
                stack.pop();
                number.append(c);
                if (!Character.isDigit(c)) {
                    break;
                }
            }
            int times = Integer.parseInt(number.reverse().toString());
            for (int j = 0; j < times; ++j) {
                for (int k = 0; k < sb.length(); ++ k) {
                    stack.push(sb.charAt(k));
                }
            }
        }
    }
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }
    return result.reverse().toString();
}