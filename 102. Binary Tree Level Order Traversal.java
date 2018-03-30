public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    int size = 1;
    while (!q.isEmpty()) {
        TreeNode node;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            node = q.poll();
            temp.add(node.val);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        result.add(temp);
        size = q.size();
    }
    return result;
}