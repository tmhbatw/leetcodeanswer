package interview;

import datastructure.TreeNode;

public class Problem4_2 {
    /*Description
    *给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
    * */

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if(start==end)
            return new TreeNode(nums[start]);
        if(end<start)
            return null;
        int mid=start+(end-start)/2;
        TreeNode res=new TreeNode(nums[mid]);
        res.left=sortedArrayToBST(nums,start,mid-1);
        res.right=sortedArrayToBST(nums,mid+1,end);
        return res;
    }
}
