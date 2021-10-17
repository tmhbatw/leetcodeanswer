package leetcode.leetcode20;

import java.util.*;

public class Leetcode1995 {

    public int countQuadruplets(int[] nums) {
        Map<Integer,Integer> set=new HashMap<>();
        for(int num:nums)
            set.put(num,set.getOrDefault(num,0)+1);
        int res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    for(int l=k+1;l<nums.length;l++){
                        if(nums[i]+nums[j]+nums[k]==nums[l])
                            res++;
                    }
                }
            }
        }
        return res;
    }
}
