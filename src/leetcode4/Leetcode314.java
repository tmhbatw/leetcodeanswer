package leetcode4;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode314 {
    /*Description
    * 给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
    * 如果两个结点在同一行和列，那么顺序则为 从左到右。
    * */

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        q1.add(root);
        q2.add(0);
        int left=0;int right=0;
        while(!q1.isEmpty()){
            TreeNode cur=q1.poll();
            int curVal=q2.poll();
            left=Math.min(curVal,left);
            right=Math.max(right,curVal);
            List<Integer> list=map.getOrDefault(curVal,new ArrayList<>());
            list.add(root.val);
            map.put(curVal,list);
            if(cur.left!=null){
                q1.add(cur.left);
                q2.add(curVal-1);
            }
            if(cur.right!=null){
                q1.add(cur.right);
                q2.add(curVal+1);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        while(left<=right){
            if(map.containsKey(left))
                result.add(map.get(left++));
        }
        return result;
    }
}
