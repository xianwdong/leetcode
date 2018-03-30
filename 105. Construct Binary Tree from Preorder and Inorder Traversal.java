/*Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.*/

public TreeNode buildTree(int[] preorder, int[] inorder) {
    return create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
}

public TreeNode create(int[] pre, int prei, int prej, int[] in , int ini, int inj) {
    if (prei > prej || ini > inj) {
        return null;
    }
    int rootVal = pre[prei];
    TreeNode root = new TreeNode(rootVal);
    int index = -1;
    for (int i = ini; i <= inj; ++i) {
        if ( in [i] == rootVal) {
            index = i;
            break;
        }
    }
    root.left = create(pre, prei + 1, prei + index - ini, in , ini, index - 1);
    root.right = create(pre, prei + index - ini + 1, prej, in , index + 1, inj);
    return root;
}