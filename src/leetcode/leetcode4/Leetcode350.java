package leetcode.leetcode4;

import java.util.*;

public class Leetcode350 {
    /*Description
    * 给定两个数组，编写一个函数来计算它们的交集。
    * */

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1=nums1.length,length2=nums2.length;
        int index1=0,index2=0;
        List<Integer> list=new ArrayList<>();
        while(index1<length1&&index2<length2){
            if(nums1[index1]<nums2[index2])
                index1++;
            else if(nums1[index1]>nums2[index2])
                index2++;
            else{
                list.add(nums1[index1++]);
                index2++;
            }
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++)
            result[i]=list.get(i);
        return result;
    }
}
