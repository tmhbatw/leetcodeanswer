package leetcode2;

import datastructure.TreeNode;

public class Leetcode108 {
    /*Description
    * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    * */

    public TreeNode sortedArrayToBST(int[] nums) {
        return changeBST(nums,0,nums.length-1);
    }

    private TreeNode changeBST(int[] nums,int start,int end){
        if(start>end)
            return null;
        if(start==end)
            return new TreeNode(nums[start]);
        int mid=(start+end)/2;
        TreeNode cur=new TreeNode(nums[mid]);
        cur.left=changeBST(nums,start,mid-1);
        cur.right=changeBST(nums,mid+1,end);
        return cur;
    }
}
