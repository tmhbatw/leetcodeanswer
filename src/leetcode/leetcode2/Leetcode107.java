package leetcode.leetcode2;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode107 {
    /*Description
    * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    * */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                list.add(cur.val);
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            result.add(0,list);
        }
        return result;

    }
}
