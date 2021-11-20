package leetcode.leetcode10;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode968 {


    public int minCameraCover(TreeNode root) {
        int[] res=getRes(root);
        return res[1];
    }

    //  返回值的第一位应该是root有摄像机且覆盖所有子树的情况，
    //  第二位是无论root有没有摄像机，覆盖所有子树的
    //  第三位是覆盖了两子树的情况，无论root有没有被覆盖到
    private int[] getRes(TreeNode root){
        if(root==null)
            return new int[]{Integer.MAX_VALUE/2,0,0};
        int[] left=getRes(root.left);
        int[] right=getRes(root.right);

        int val1=1+left[2]+right[2];
        int val2=Math.min(left[0]+right[2],left[2]+right[0]);
        val2=Math.min(val1,val2);
        int val3=left[1]+right[1];
        val3=Math.min(val3,val2);
        return new int[]{val1,val2,val3};
    }
}
