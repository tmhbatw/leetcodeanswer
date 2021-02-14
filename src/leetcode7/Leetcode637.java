package leetcode7;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode637 {
    /*Description
    * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
    * */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            double res=0;
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                res+=cur.val;
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            result.add(res/size);
        }
        return result;
    }
}
