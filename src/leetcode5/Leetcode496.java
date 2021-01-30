package leetcode5;

import java.util.HashMap;
import java.util.Map;

public class Leetcode496 {
    /*Description
    * 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
    * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。
    * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
    * */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        int length2=nums2.length,length1=nums1.length;
        for(int i=0;i<length2;i++)
            map.put(nums2[i],i);
        int[] result=new int[length1];
        for(int i=0;i<length1;i++){
            int cur=nums1[i];
            int index=map.get(cur);
            result[i]=-1;
            for(int j=index+1;j<length2;j++){
                if(nums2[j]>cur) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
