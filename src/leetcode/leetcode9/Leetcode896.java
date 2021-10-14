package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.List;

public class Leetcode896 {
    public boolean isMonotonic(int[] nums) {
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]||
                nums[i]<nums[i-1]&&nums[i]<nums[i+1])
                return false;
        }
        return true;
    }

    private List<Integer> getList(int[] nums){
        int length=nums.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<length;i++){
            list.add(nums[i]);
            while(i<length-1&&nums[i+1]==nums[i])
                i++;
        }
        return list;
    }
}
