package leetcode2;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode111 {
    /*Description
    * 给定一个二叉树，找出其最小深度。
    * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    * 说明：叶子节点是指没有子节点的节点。
    * */

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int result=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left==null&&cur.right==null)
                    return result;
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            result++;
        }
        return result;
    }
}
