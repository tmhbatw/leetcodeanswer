package leetcode7;

import datastructure.TreeNode;

public class Leetcode654 {
    /*Description
    * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
    * 二叉树的根是数组 nums 中的最大元素。
    * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
    * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
    * 返回有给定数组 nums 构建的 最大二叉树 。
    * */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int[] nums,int start,int end){
        if(start>end)
            return null;
        if(start==end)
            return new TreeNode(nums[start]);
        int index=start;
        int max=nums[start];
        for(int i=start+1;i<=end;i++){
            if(nums[i]>max){
                index=i;
                max=nums[i];
            }
        }
        TreeNode cur=new TreeNode(max);
        cur.left=construct(nums,start,index-1);
        cur.right=construct(nums,index+1,end);
        return cur;
    }
}
