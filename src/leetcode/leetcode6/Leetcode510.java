package leetcode.leetcode6;

public class Leetcode510 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    Node result;
    int target;
    int cur=Integer.MAX_VALUE;
    public Node inorderSuccessor(Node node) {
        this.target=node.val;
        Node root=node;
        while(root.parent!=null)
            root= root.parent;

        dfs(root);
        return result;
    }



    private void dfs(Node node){
        if(node.val>target&&node.val<cur){
            cur=node.val;
            result=node;
        }
        if(node.left!=null)
            dfs(node.left);
        if(node.right!=null)
            dfs(node.right);
    }
}
