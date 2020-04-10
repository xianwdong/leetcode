// Given a list of daily temperatures T, return a list such that, for each day in the input, 
// ells you how many days you would have to wait until a warmer temperature. 
// If there is no future day for which this is possible, put 0 instead.

// For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
// your output should be [1, 1, 4, 2, 1, 1, 0, 0].

// 我的算法比较丑陋，我选择把元素本身放到栈里，但其实可以把下标放到栈里
public int[] dailyTemperatures(int[] T) {
    int length = T.length;
    Stack<ValAndIndex> stack = new Stack<>();
    int[] result = new int[length];
    for (int i = 0; i < length; ++i) {
        if (stack.isEmpty()) {
            stack.push(new ValAndIndex(T[i], i));
        } else {
            if (T[i] <= stack.peek().val) {
                stack.push(new ValAndIndex(T[i], i));
            } else {
                while (!stack.isEmpty() && T[i] > stack.peek().val) {
                    int index = stack.peek().index;
                    result[index] = i - index;
                    stack.pop();
                }
                stack.push(new ValAndIndex(T[i], i));
            }
        }
    }
    return result;
}

static class ValAndIndex {
    int val;
    int index;

    public ValAndIndex(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

// 更优雅的算法
public int[] dailyTemperatures(int[] t) {
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[t.length];
    for (int i = 0; i < t.length; i++) {
        while (!st.isEmpty() && (t[st.peek()] < t[i]))
            // 如果当前元素比栈顶元素大，那么栈顶元素就可以pop出来了，记下让它pop的元素的下标
            ans[st.pop()] = i;
        // 把下标放到栈里
        st.push(i);
    }
    for (int i = 0; i < ans.length; i++)
        ans[i] = (ans[i] == 0) ? 0 : (ans[i] - i);
    return ans;
}