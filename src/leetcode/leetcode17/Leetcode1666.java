package leetcode.leetcode17;

public class Leetcode1666 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    private Node root;
    public Node flipBinaryTree(Node root, Node leaf) {
        this.root = root;
        dfs(leaf);
        leaf.parent = null;
        return leaf;
    }
    private void dfs(Node cur) {
        if (cur == root)
            return;
        Node left = cur.left;
        Node parent = cur.parent;
        if (cur.left != null) {
            cur.right = left;
        }
        cur.left = parent;
        if (parent.left == cur)
            parent.left = null;
        if (parent.right == cur)
            parent.right = null;
        dfs(parent);
        parent.parent = cur;
    }
}
