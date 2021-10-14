package leetcode.leetcode11;

import java.util.Arrays;
import java.util.OptionalInt;

public class Leetcode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        for(;i<Math.min(nums.length,k);i++){
            if(nums[i]>=0)
                break;
            nums[i]=-nums[i];
        }

        k-=i;
        int sum= Arrays.stream(nums).sum();
        if(k%2==1){
            int min=Arrays.stream(nums).min().getAsInt();
            sum-=min*2;
        }
        return sum;
    }
}
