package leetcode.leetcode4;

import java.util.*;

public class Leetcode368 {
    /*Description
    * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对
    * (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
    * 如果有多个目标子集，返回其中任何一个均可。
    * */

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums==null||nums.length==0)
            return Collections.EMPTY_LIST;
        int length=nums.length;
        int[] dp=new int[length];
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        int max=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            int preMax=0;
            int index=-1;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[j]>preMax){
                        index=j;
                        preMax=dp[j];
                    }
                }
            }
            List<Integer> curList=new ArrayList<>();
            if(index!=-1)
                curList.addAll(list.get(index));
            curList.add(nums[i]);
            list.add(curList);
            dp[i]=preMax+1;
            if(max<dp[i]){
                max=dp[i];
                res=i;
            }
        }
        return list.get(res);
    }
}
