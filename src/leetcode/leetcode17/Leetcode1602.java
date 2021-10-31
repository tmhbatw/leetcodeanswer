package leetcode.leetcode17;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1602 {

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Queue<TreeNode> newQueue=new LinkedList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur==u)
                    return q.isEmpty()?null:q.poll();
                if(cur.left!=null)
                    newQueue.add(cur.left);
                if(cur.right!=null)
                    newQueue.add(cur.right);
            }
            q=newQueue;
        }

        return null;
    }

}
