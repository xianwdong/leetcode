A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].
Sets S[K] for 0 <= K < N are defined as follows:
S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
Sets S[K] are finite for each K and should NOT contain duplicates.
Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

// my code
public static int arrayNesting(int[] nums) {
    Set set = new HashSet < > ();
    boolean[] visited = new boolean[nums.length];
    int maxLength = 1, curIndex = 0;
    for (int i = 0; i < nums.length; ++i) {
        curIndex = i;
        if (!visited[i]) {
            while (!set.contains(nums[curIndex])) {
                visited[curIndex] = true;
                set.add(nums[curIndex]);
                curIndex = nums[curIndex];
            }
            maxLength = Math.max(maxLength, set.size());
            set.clear();
        }
    }
    return maxLength;
}
// a better code
// 通过将数设为1来代替用数组记录是否被访问
public int arrayNesting(int[] nums) {
    int maxLength = 0;
    for (int i = 0; i < nums.length; ++i) {
        int curLength = 0;
        for (int k = i; nums[k] >= 0; ++curLength) {
            int ak = nums[k];
            nums[k] = -1;
            k = ak;
        }
        maxLength = Math.max(maxLength, curLength);
    }
    return maxLength;
}