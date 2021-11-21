package leetcode.leetcode10;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode958 {

    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
            return true;

        boolean empty=false;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null){
                if(empty)
                    return false;
                q.add(cur.left);
            }else
                empty=true;
            if(cur.right!=null){
                if(empty)
                    return false;
                q.add(cur.right);
            }else
                empty=true;
        }
        return true;
    }
}
