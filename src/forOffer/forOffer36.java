package forOffer;

public class forOffer36 {
    /*Description
    * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
    * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
     * */

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    Node result=null;
    Node cur=null;
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
        dfs(root);
        cur.right=result;
        result.left=cur;
        return result;
    }

    private void dfs(Node root){
        if(root==null)
            return;
        dfs(root.left);
        if(result==null) {
            result = root;
            cur=result;
        }
        else{
            root.left=cur;
            cur.right=root;
            cur=root;
        }
        dfs(root.right);
    }
}
