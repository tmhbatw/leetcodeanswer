package leetcode.leetcode6;

import java.util.ArrayList;
import java.util.List;

public class Leetcode589 {
    /*Description
    * 给定一个 N 叉树，返回其节点值的前序遍历。
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

    public List<Integer> preorder(Node root) {
        List<Integer> result=new ArrayList<>();
        preOrder(root,result);
        return result;
    }

    private void preOrder(Node root,List<Integer> list){
        if(root!=null){
            list.add(root.val);
            for(Node cur:root.children)
                preOrder(cur,list);
        }
    }
}
