package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2389 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }

        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int cur=queries[i];
            if(cur<nums[0])
                continue;
            int l=0,r=nums.length-1;
            while(l<r){
                int mid=(l+r+1)/2;
                if(nums[mid]<=queries[i])
                    l=mid;
                else{
                    r=mid-1;
                }
            }
            res[i]=l+1;
        }
        return res;
    }

}
