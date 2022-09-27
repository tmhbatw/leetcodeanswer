package leetcode.leetcode25;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2420 {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] right=new int[nums.length];
        int cur=1;
        for(int i=nums.length-2;i>=0;i--){
            right[i]=cur;

            if(nums[i]<=nums[i+1])
                cur++;
            else cur=1;
        }
        cur=1;
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            if(cur>=k&&right[i]>=k)
                result.add(i);
            if(nums[i]<=nums[i-1])
                cur++;
            else cur=1;



        }

        return result;
    }

}
