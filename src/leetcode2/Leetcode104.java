package leetcode2;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode104 {
    /*Description
    * 给定一个二叉树，找出其最大深度。
    * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    * 说明: 叶子节点是指没有子节点的节点。
    * */

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int result=0;
        while(!queue.isEmpty()){
            result++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
        }
        return result;
    }
}
