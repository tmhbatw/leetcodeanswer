package leetcode.leetcode6;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode513 {
    /*Description
    * 给定一个二叉树，在树的最后一行找到最左边的值。
    * */

    public int findBottomLeftValue(TreeNode root) {
        int left=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(i==0)
                    left=cur.val;
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        return left;
    }
}
