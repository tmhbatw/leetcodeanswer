package leetcode.leetcode25;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2401
{

    public int longestNiceSubarray(int[] nums) {
        int result = 0;
        int pre =0;

        for(int i=0;i<nums.length;i++){
            for(int j=i-1;j>=pre;j--){
                //System.out.println(nums[i]+" "+nums[j]+" "+(nums[i]&nums[j]));

                if((nums[i]&nums[j])!=0){
                    pre = j+1;
                    break;
                }
            }
            //System.out.println(i+" "+pre);
            result=Math.max(result,i-pre+1);
        }
        return result;
    }


}
