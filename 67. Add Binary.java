public static String addBinary(String a, String b) {
    int i = a.length() - 1, j = b.length() - 1;
    StringBuilder result = new StringBuilder("");
    int carry = 0;
    while (i >= 0 && j >= 0) {
        result.append((a.charAt(i) + b.charAt(j) - '0' - '0' + carry) % 2);
        carry = (a.charAt(i--) + b.charAt(j--) - '0' - '0' + carry) / 2;
    }
    while (i >= 0) {
        result.append((a.charAt(i) - '0' + carry) % 2);
        carry = (a.charAt(i--) - '0' + carry) / 2;
    }
    while (j >= 0) {
        result.append((b.charAt(j) - '0' + carry) % 2);
        carry = (b.charAt(j--) - '0' + carry) / 2;
    }
    if (carry == 1) {
        result.append('1');
    }
    return result.reverse().toString();
}

public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1, j = b.length() - 1, carry = 0;
    while (i >= 0 || j >= 0) {
        int sum = carry;
        if (j >= 0) sum += b.charAt(j--) - '0';
        if (i >= 0) sum += a.charAt(i--) - '0';
        sb.append(sum % 2);
        carry = sum / 2;
    }
    if (carry != 0) sb.append(carry);
    return sb.reverse().toString();
}