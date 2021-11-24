package leetcode.leetcode14;

import datastructure.TreeNode;

public class Leetcode1373 {

    int result=0;
    public int maxSumBST(TreeNode root) {
        getRes(root);
        return result;
    }

    //第一位是最小值，第二位是最大值。第三位是和，第四位表示状态
    //状态分为：
    //0：为null   1：是一个二叉搜索子树    2：不是
    private int[] getRes(TreeNode root){
        if(root==null)
            return new int[]{0,0,0,0};

        int[] left=getRes(root.left);
        int[] right=getRes(root.right);


        if(left[3]==2||left[3]==1&&left[1]>=root.val||right[3]==2||
                right[0]<=root.val&&right[3]==1)
            return new int[]{0,0,0,2};

        int val=left[2]+right[2]+root.val;
        result=Math.max(val,result);
        int l=left[3]==0?root.val:left[0];
        int r=right[3]==0?root.val:right[1];
        return new int[]{l,r,val,1};
    }
}
