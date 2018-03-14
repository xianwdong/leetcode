/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
  /   \
 2     2
/ \   / \
3  4  4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
    3   3*/

public static boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    return help(root.left, root.right);
}

public static boolean help(TreeNode left, TreeNode right) {
    if (left != null && right != null) {
        return left.val == right.val && help(left.left, right.right) && help(left.right, right.left);
    } else if (left == null && right == null) {
        return true;
    } else {
        return false;
    }
}