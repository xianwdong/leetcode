/*Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).*/

public List < List < Integer >> zigzagLevelOrder(TreeNode root) {
    List < List < Integer >> result = new ArrayList < > ();
    if (root == null) {
        return result;
    }
    Queue < TreeNode > q = new LinkedList < > ();
    q.add(root);
    boolean order = true;
    int size = 1;
    while (!q.isEmpty()) {
        List < Integer > list = new LinkedList < > ();
        for (int i = 0; i < size; ++i) {
            TreeNode node = q.poll();
            if (order) {
                list.add(node.val);
            } else {
                list.add(0, node.val);
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        result.add(list);
        size = q.size();
        order = order ? false : true;
    }
    return result;
}