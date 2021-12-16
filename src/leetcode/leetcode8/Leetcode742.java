package leetcode.leetcode8;

import datastructure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode742 {

    TreeNode source=null;
    int k=0;
    Map<TreeNode,TreeNode> father=new HashMap<>();
    Map<TreeNode,int[]> map=new HashMap<>();
    public int findClosestLeaf(TreeNode root, int k) {
        this.k=k;
        dfs(root);


        if(source==null)
            source=root;
        int height=Integer.MAX_VALUE;
        int add=0;
        int result=0;
        while(source!=null){
            int[] cur=map.get(source);
            cur[0]+=add++;
            if(cur[0]<height){
                height=cur[0];
                result=cur[1];
            }
            source=father.get(source);
        }

        return result;
    }

    private int[] dfs(TreeNode root){
        int height=Integer.MAX_VALUE;
        int val=root.val;

        if(root.left!=null){
            if(root.left.val==k)
                source=root.left;
            father.put(root.left,root);
            int[] l=dfs(root.left);
            if(l[0]<height) {
                height=l[0];
                val = l[1];
            }
        }
        if(root.right!=null){
            if(root.right.val==k){
                source=root.right;
            }
            father.put(root.right,root);
            int[] r=dfs(root.right);
            if(r[0]<height){
                height=r[0];
                val=r[1];
            }
        }

        int[] cur=height==Integer.MAX_VALUE?new int[]{0,root.val}:
                new int[]{height+1,val};
        map.put(root,cur);
        return cur;
    }
}
