package leetcode.leetcode6;

import datastructure.TreeNode;

public class Leetcode549 {

    int result=1;
    public int longestConsecutive(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode root){
        if(root==null)
            return new int[]{Integer.MAX_VALUE,0,0};

        int[] l=dfs(root.left);
        int[] r=dfs(root.right);

        if(l[0]==Integer.MAX_VALUE&&r[0]==Integer.MAX_VALUE)
            return new int[]{root.val,1,1};
        if(l[0]==Integer.MAX_VALUE)
            return getRes(root.val,r);
        if(r[0]==Integer.MAX_VALUE)
            return getRes(root.val,l);
        int[] res=new int[]{root.val,1,1};

        if(l[0]==root.val+1)
            res[2]=Math.max(res[2],1+l[2]);
        if(l[0]==root.val-1)
            res[1]=Math.max(res[1],1+l[1]);

        if(r[0]==root.val+1)
            res[2]=Math.max(res[2],1+r[2]);
        if(r[0]==root.val-1)
            res[1]=Math.max(res[1],1+r[1]);

        result=Math.max(result,res[1]+res[2]-1);
        return res;
    }

    private int[] getRes(int val,int[] num){
        int[] res=new int[]{val,1,1};
        if(num[0]==val+1){
            res[2]+=num[2];
            result=Math.max(res[2],result);
        }
        if(num[0]==val-1){
            res[1]+=num[1];
            result=Math.max(res[1],result);
        }
        return res;
    }
}
