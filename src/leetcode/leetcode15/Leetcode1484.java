package leetcode.leetcode15;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1484 {


    public class Node {
        int val;
        Node left;
        Node right;
        Node random;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;
        NodeCopy() {}
        NodeCopy(int val) { this.val = val; }
        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    Map<Node,NodeCopy> map=new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root==null)
            return null;
        NodeCopy result=copy(root);
        dfs(root,result);
        return result;
    }

    private void dfs(Node root,NodeCopy result){
        if(root==null)
            return;
        if(root.random!=null){
            result.random=map.get(root.random);
        }
        dfs(root.left,result.left);
        dfs(root.right,result.right);
    }

    private NodeCopy copy(Node root){
        if(root==null)
            return null;
        NodeCopy cur=new NodeCopy(root.val);
        map.put(root,cur);
        cur.left=copy(root.left);
        cur.right=copy(root.right);
        return cur;
    }
}
