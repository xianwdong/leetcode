/*Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.*/

public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
}

public TreeNode buildTree(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
    if (inend < instart || postend < poststart) {
        return null;
    }
    TreeNode root = new TreeNode(postorder[postend]);
    int index = -1;
    for (int i = instart; i <= inend; ++i) {
        if (inorder[i] == postorder[postend]) {
            index = i;
            break;
        }
    }
    root.left = buildTree(inorder, postorder, instart, index - 1, poststart, poststart + index - instart - 1);
    root.right = buildTree(inorder, postorder, index + 1, inend, poststart + index - instart, postend - 1);
    return root;
}