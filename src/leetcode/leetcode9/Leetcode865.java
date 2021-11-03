package leetcode.leetcode9;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode865 {
    List<TreeNode> list=new ArrayList<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            list=new ArrayList<>(q);
            int size=q.size();
            while(size-->0){
                TreeNode cur=q.poll();
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        return getRes(list,root);
    }

    private TreeNode getRes(List<TreeNode> list,TreeNode root){
        if(root==null)
            return null;
        if(list.contains(root))
            return root;
        TreeNode l=getRes(list,root.left);
        TreeNode r=getRes(list,root.right);

        if(l==null)
            return r;
        if(r==null)
            return l;
        return root;
    }
}
