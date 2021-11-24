package leetcode.leetcode15;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1457 {

    public int pseudoPalindromicPaths (TreeNode root) {
        int result=0;
        int[] time=new int[10];
        time[root.val]++;

        Queue<TreeNode> q1=new LinkedList<>();
        Queue<int[]>    q2=new LinkedList<>();
        q1.add(root);
        q2.add(time);

        while(!q1.isEmpty()){
            TreeNode node=q1.poll();
            int[] cur=q2.poll();

            if(node.left==null&&node.right==null){
                result+=getRes(cur)?1:0;
            }

            if(node.left!=null){
                int[] curr=cur.clone();
                curr[node.left.val]++;
                q1.add(node.left);
                q2.add(curr);
            }

            if(node.right!=null){
                int[] curr=cur.clone();
                curr[node.right.val]++;
                q1.add(node.right);
                q2.add(curr);
            }
        }
        return result;
    }

    private boolean getRes(int[] nums){
        int count=0;
        for(int num:nums){
            if(num%2==1){
                count++;
            }
        }
        return count<=1;
    }
}
