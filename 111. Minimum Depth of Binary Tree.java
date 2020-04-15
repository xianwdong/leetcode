// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// Note: A leaf is a node with no children.
// Example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its minimum depth = 2.

public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    ArrayDeque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    int depth = 0;
    while (!deque.isEmpty()) {
        ++depth;
        int number = deque.size();
        for (int i = 0; i < number; ++i) {
            TreeNode treeNode = deque.pollFirst();
            if (treeNode.left == null && treeNode.right == null) {
                return depth;
            }
            if (treeNode.left != null) {
                deque.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.add(treeNode.right);
            }
        }
    }
    return depth;
}