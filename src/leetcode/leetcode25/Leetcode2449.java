package leetcode.leetcode25;

import java.util.Arrays;

public class Leetcode2449 {

    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);

        int m=0,n=0;
        long result=0;
        for(int i=0;i<nums.length;i++){
            int cur;
            if(nums[i]%2==0){
                while(target[m]%2==1)
                    m++;
                cur=target[m++];
            }else{
                while(target[n]%2==1)
                    n++;
                cur=target[n++];
            }
            if(cur>nums[i])
                result+=(cur-nums[i])/2;
        }

        return result;
    }


}
