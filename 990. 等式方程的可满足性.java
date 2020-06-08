990. 等式方程的可满足性
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一：
"a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
示例 1：
输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：
输入：["b==a","a==b"]
输出：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：
输入：["a==b","b==c","a==c"]
输出：true
示例 4：
输入：["a==b","b!=c","c==a"]
输出：false
示例 5：
输入：["c==c","b==d","x!=z"]
输出：true

比较明显的一个并查集题目

public static boolean equationsPossible(String[] equations) {
    int[] parent = new int[26];
    for (int i = 0; i < 26; ++i) {
        parent[i] = i;
    }
    for (String s : equations) {
        if (s.charAt(1) == '=') {
            int left = s.charAt(0) - 'a';
            int right = s.charAt(3) - 'a';
            union(parent, left, right);
        }
    }
    for (String s : equations) {
        if (s.charAt(1) == '!') {
            int left = s.charAt(0) - 'a';
            int right = s.charAt(3) - 'a';
            if (find(parent, left) == find(parent, right)) {
                return false;
            }
        }
    }
    return true;
}

// 注意合并两个集合的时候，对于每个集合都要找到它的parent，然后把其中的一个赋值给另外一个
private static void union(int[] parent, int left, int right) {
    int index = find(parent, left);
    parent[find(parent, right)] = index;
}

private static int find(int[] parent, int number) {
    if (number == parent[number]) {
        return number;
    }
    return find(parent, parent[number]);
}