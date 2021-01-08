package leetcode3;

import java.util.Arrays;

public class Leetcode215 {
    /*Description
    * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    * */

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,nums.length+1-k,0,nums.length-1);
    }

    private int findKthLargest(int[] nums,int k,int start,int end){
        if(start==end)
            return nums[start];
        int s=nums[start];
        int left=start+1,right=end;
        while(left<right){
            if(nums[left]<=s)
                left++;
            else if(nums[right]>s)
                right--;
            else{
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }
        if(nums[left]>nums[start])
            left--;
        nums[start]=nums[left];
        nums[left]=s;
        if(left==k-1)
            return s;
        if(left<k-1)
            return findKthLargest(nums,k,left+1,end);
        return findKthLargest(nums,k,start,left-1);
    }

    public static void main(String[] args){
        int[] num=new int[]{3,2,1,5,6,4};
        System.out.println(new Leetcode215().findKthLargest(num,2));
    }
}
