/*Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
Example 1:
Input:
Tree 1 Tree 2
       1      2
      / \    / \
     3   2  1   3
    / \   \
   5   4   7
Output:
Merged tree:
    3
   / \
  4   5
 / \   \
5   4   7
Note: The merging process must start from the root nodes of both trees.*/

public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    TreeNode root;
    if (t1 == null && t2 == null) {
        return null;
    }
    root = new TreeNode(0);
    if (t1 != null && t2 != null) {
        root.val = t1.val + t2.val;
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
    } else if (t1 != null && t2 == null)
        return t1;
    } else {
        return t2;
    }
    return root;
}

public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
    TreeNode newNode = new TreeNode(val);
    newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
    newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
    return newNode;
}