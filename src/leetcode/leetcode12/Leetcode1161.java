package leetcode.leetcode12;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1161 {

    public int maxLevelSum(TreeNode root) {
        int val=Integer.MIN_VALUE;
        int res=0;

        int layer=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            while(size-->0){
                TreeNode cur=q.poll();
                sum+=cur.val;
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }

            if(sum>val){
                val=sum;
                res=layer;
            }
            layer++;
        }
        return res;
    }
}
