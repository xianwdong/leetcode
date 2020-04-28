// Given a binary tree, imagine yourself standing on the right side of it, 
// return the values of the nodes you can see ordered from top to bottom.
// Example:
// Input: [1,2,3,null,5,null,4]
// Output: [1, 3, 4]
// Explanation:
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---

// 层序遍历
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    LinkedList<TreeNode> list = new LinkedList<>();
    list.addLast(root);
    result.add(root.val);
    while (!list.isEmpty()) {
        int size = list.size();
        for (int i = 0; i < size; ++i) {
            TreeNode node = list.removeFirst();
            if (node.left != null) {
                list.addLast(node.left);
            }
            if (node.right != null) {
                list.addLast(node.right);
            }
        }
        if (!list.isEmpty())
            result.add(list.getLast().val);
    }
    return result;
}

// 一个递归算法
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    rightView(root, result, 0);
    return result;
}

public void rightView(TreeNode curr, List<Integer> result, int currDepth){
    if(curr == null){
        return;
    }
    if(currDepth == result.size()){
        result.add(curr.val);
    }
    rightView(curr.right, result, currDepth + 1);
    rightView(curr.left, result, currDepth + 1);
    
}