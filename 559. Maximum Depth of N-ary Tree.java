// Given a n-ary tree, find its maximum depth.
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
// Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

public int maxDepth(Node root) {
    if (root == null) {
        return 0;
    }
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    int depth = 0;
    while (!stack.isEmpty()) {
        ++depth;
        // 其实这里完全没必要用一个List存，直接取stack的size，然后循环size次就行了
        List<Node> nodeList = new ArrayList<>();
        while (!stack.isEmpty()) {
            nodeList.add(stack.pop());
        }
        for (Node node : nodeList) {
            if (node.children != null) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
    }
    return depth;
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};