package leetcode.leetcode20;

public class Leetcode1979 {

    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int cur:nums){
            min=Math.min(cur,min);
            max=Math.max(cur,max);
        }
        return getRes(min,max);
    }

    private int getRes(int min,int max){
        if(max%min==0)
            return min;
        return getRes(max%min,min);
    }
}
