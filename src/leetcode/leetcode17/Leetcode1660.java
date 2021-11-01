package leetcode.leetcode17;

import datastructure.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode1660 {

    public TreeNode correctBinaryTree(TreeNode root) {
        TreeNode wrongNode=findWrongNode(root);
        remove(root,wrongNode);
        return root;
    }

    private void remove(TreeNode root,TreeNode wrongNode){
        if(root==null)
            return;
        if(root.left==wrongNode) {
            root.left = null;
            return;
        }
        if(root.right==wrongNode){
            root.right=null;
            return;
        }
        remove(root.left,wrongNode);
        remove(root.right,wrongNode);
    }

    private TreeNode findWrongNode(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        Set<TreeNode> set=new HashSet<>();
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null){
                set.add(cur.left);
                q.add(cur.left);
            }
            if(cur.right!=null){
                if(set.contains(cur.right))
                    return cur;
                set.add(cur.right);
                q.add(cur.right);
            }
        }
        return null;
    }
}
