package leetcode.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class Leetcode163 {
    /*Description
    * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
     * */

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int length=nums.length;
        List<String> result=new ArrayList<>();
        int start=lower;
        for(int i=0;i<length;i++){
            if(nums[i]>upper) {
                break;
            }
            if(nums[i]<lower)
                continue;
            if(nums[i]==start) {
                while (i < length - 1 && nums[i+1]-nums[i]==1) {
                    i++;
                }
            }else{
                result.add(getRes(start,nums[i]-1));
            }
            start=nums[i]+1;
        }
        if(start<=upper)
            result.add(getRes(start,upper));
        return result;
    }

    private String getRes(int start,int end){
        if(start==end)
            return start+"";
        return start+"->"+end;
    }
}
