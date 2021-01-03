package leetcode2;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode103 {
    /*Description
    * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean reverse=false;
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
                if(!reverse) {
                    list.add(cur.val);
                }else
                    list.add(0,cur.val);
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            result.add(list);
            reverse=!reverse;
        }
        return result;
    }
}
