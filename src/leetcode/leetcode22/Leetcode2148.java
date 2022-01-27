package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2148 {

    public int countElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }

        int result=0;
        for(int num:nums){
            if(num>min&&num<max){
                result++;
            }
        }
        return result;
    }
}
