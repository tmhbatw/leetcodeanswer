package leetcode.leetcode6;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode515 {
    /*Description
    * 您需要在二叉树的每一行中找到最大的值。
    * */

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                max=Math.max(cur.val,max);
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            result.add(max);
        }
        return result;
    }
}
