package leetcode.leetcode2;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode102 {
    /*Description
    * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * */

    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(list);
        }
        return result;
    }
}
