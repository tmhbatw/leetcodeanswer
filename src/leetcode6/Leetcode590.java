package leetcode6;

import java.util.ArrayList;
import java.util.List;

public class Leetcode590 {
    /*Description
    * 给定一个 N 叉树，返回其节点值的后序遍历。
    * */

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


    public List<Integer> postorder(Node root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        postOrder(root,result);
        return result;
    }

    private void postOrder(Node root,List<Integer> list){
            for(Node cur:root.children){
                postOrder(cur,list);
            }
            list.add(root.val);
    }
}
