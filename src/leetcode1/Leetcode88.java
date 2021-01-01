package leetcode1;

import java.util.Arrays;

public class Leetcode88 {
    /*Description
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * */


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result=new int[m+n];
        int index1=0,index2=0,index=0;
        while(index1<m||index2<n){
            int cur1=index1>=m?Integer.MAX_VALUE:nums1[index1];
            int cur2=index2>=n?Integer.MAX_VALUE:nums2[index2];
            if(cur1<cur2){
                index1++;
                result[index++]=cur1;
            }else{
                index2++;
                result[index++]=cur2;
            }
        }

        for(int i=0;i<m+n;i++)
            nums1[i]=result[i];
    }
}
