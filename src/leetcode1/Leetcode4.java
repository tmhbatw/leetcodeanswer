package leetcode1;

import java.util.Arrays;

public class Leetcode4 {
    /*Description
    * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
    * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1==null||nums1.length==0)&&(nums2==null||nums2.length==0))
            return 0;
        if(nums1==null||nums1.length==0)
            return getMedian(nums2);
        if(nums2==null||nums2.length==0)
            return getMedian(nums1);
        if(nums1.length<nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int m=nums1.length,n=nums2.length;
        int k=m+n;
        boolean evenNumber=k%2==0;
        k/=2;
        int left=0,right=n;
        while(left<=right){
            int mid=left+(right-left)/2;
            int number1=k-mid;
            int small2=mid==0?Integer.MIN_VALUE:nums2[mid-1];
            int big2=mid==n?Integer.MAX_VALUE:nums2[mid];
            int small1=number1==0?Integer.MIN_VALUE:nums1[number1-1];
            int big1=number1==m?Integer.MAX_VALUE:nums1[number1];
            int min=Math.max(small1,small2),max=Math.min(big1,big2);
            if(min<=max)
                return evenNumber?(min+max)*1.0/2:max;
            else{
                if(small2>small1){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return 0.0;
    }


    private double getMedian(int[] num){
        int m=num.length;
        return (num[m/2]+num[(m-1)/2])*1.0/2;
    }
}
