/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

1
 \
  2
 /
3
return [1,2,3].
Note: Recursive solution is trivial, could you do it iteratively?*/

public List < Integer > preorderTraversal(TreeNode root) {
    Stack < TreeNode > stack = new Stack < > ();
    List < Integer > result = new ArrayList < > ();
    while (!stack.isEmpty() || root != null) {
        while (root != null) {
            result.add(root.val);
            stack.add(root);
            root = root.left;
        }
        root = stack.pop();
        root = root.right;
    }
    return result;
}
// 只把右边节点加入栈中
public List < Integer > preorderTraversal(TreeNode node) {
    List < Integer > list = new LinkedList < Integer > ();
    Stack < TreeNode > rights = new Stack < TreeNode > ();
    while (node != null) {
        list.add(node.val);
        if (node.right != null) {
            rights.push(node.right);
        }
        node = node.left;
        if (node == null && !rights.isEmpty()) {
            node = rights.pop();
        }
    }
    return list;
}