package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2122 {

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);

        for(int j=1;j<nums.length;j++){
            if(nums[j]==nums[0])
                continue;
            if((nums[j]-nums[0])%2==0){
                if(isMatch(nums,(nums[j]-nums[0]))){
                    return getRes(nums,(nums[j]-nums[0]));
                }
            }
        }

        return new int[0];
    }

    private boolean isMatch(int[] nums,int k){
        int j=1;
        int length=nums.length;
        boolean[] reached=new boolean[length];

        for(int i=0;i<length;i++){
            if(reached[i])
                continue;
            j=Math.max(i+1,j);
            while(j<length&&nums[j]-nums[i]<k){
                j++;
            }
            if(j==length||nums[j]-nums[i]>k)
                return false;
            reached[j++]=true;
        }
        return true;
    }

    private int[] getRes(int[] nums,int k){
        int[] result=new int[nums.length/2];

        int j=0;
        boolean[] reached=new boolean[nums.length];
        int index=0;

        for(int i=0;i<nums.length;i++){
            if(reached[i])
                continue;

            result[index++]=nums[i]+k/2;

            while(nums[j]<nums[i]+k){
                j++;
            }
            reached[j++]=true;
        }
        return result;
    }


}
