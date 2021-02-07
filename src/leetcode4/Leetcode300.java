package leetcode4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode300 {
    /*Description
    * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
    * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    * */

    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        int result=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>list.get(result-1)) {
                result++;
                list.add(nums[i]);
            }else{
                int l=0,r=result-1;
                while(l<=r){
                    int mid=l+(r-l)/2;
                    if(list.get(mid)<nums[i]){
                        l=mid+1;
                    }else if(mid==0||list.get(mid-1)<nums[i]) {
                        list.set(mid, nums[i]);
                        break;
                    }else
                        r=mid-1;
                }
            }
        }
        System.out.println(list);
        return result;
    }
}
