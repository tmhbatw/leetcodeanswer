package leetcode.leetcode5;

import datastructure.TreeNode;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.List;

public class Leetcode431 {

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

    class Codec {

        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if(root==null)
                return null;
            TreeNode result=new TreeNode(root.val);
            List<TreeNode> child=new ArrayList<>();
            for(Node n:root.children){
                TreeNode node= encode(n);
                if(node!=null)
                    child.add(node);
            }
            if(child.isEmpty())
                return result;
            result.left=child.get(0);
            TreeNode cur=result.left;
            for(int i=1;i<child.size();i++){
                cur.right=child.get(i);
                cur=cur.right;
            }
            return result;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if(root==null)
                return null;
            Node result=new Node(root.val,new ArrayList<>());
            TreeNode left=root.left;
            while(left!=null){
                result.children.add(decode(left));
                left=left.right;
            }
            return result;
        }
    }
}
