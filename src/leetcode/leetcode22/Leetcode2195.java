package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2195 {

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        //把从1到l的全部整数全加到数组中
        int l=1,r=Integer.MAX_VALUE;
        while(l<r){
            int mid= l+(r-l)/2;
            if(match(nums,k,mid))
                r=mid;
            else l=mid+1;
        }

        long result=0;
        int pre=0;
        for (int num : nums) {
            if (num > l) {
                result += getRes(pre, l + 1);
                return result;
            }
            result += getRes(pre, num);
            pre = num;
        }
        return result+getRes(nums[nums.length-1],l+1);
    }

    private long getRes(int l,int r){
        if(l>=r)
            return 0;
        return (long) (l + r ) *(r-l-1)/2;
    }

    private boolean match(int[] nums,int k,int mid){
        if(mid<nums[0])
            return mid>=k;
        int count  = 0;
        int pre=0;
        for (int num : nums) {
            if (mid < num) {
                count += mid-pre;
                break;
            } else {
                count += Math.max(num - pre - 1, 0);
                pre = num;
            }
        }
        return Math.max(0,mid-nums[nums.length-1])+count>=k;
    }

}
