package leetcode.leetcode21;

import java.util.Arrays;

public class Leetcode2098 {

    public long largestEvenSum(int[] nums, int k) {
        long result=0;
        Arrays.sort(nums);

        for(int j=nums.length-1;j>=nums.length-k;j--)
            result+=nums[j];
        if(result%2==0)
            return result;

        //要不就是把一个最小的偶数换成一个最大的奇数
        int e1=Integer.MAX_VALUE;
        int p1=Integer.MAX_VALUE;
        for(int i=nums.length-k;i<nums.length;i++){
            if(nums[i]%2==1)
                e1=Math.min(e1,nums[i]);
            if(nums[i]%2==0)
                p1=Math.min(p1,nums[i]);
        }

        //要不就是把一个最小的奇数换成最大的偶数
        int e2=-1;
        int p2=-1;

        for(int i=0;i<nums.length-k;i++){
            if(nums[i]%2==1)
                e2=Math.max(e2,nums[i]);
            if(nums[i]%2==0)
                p2=Math.max(p2,nums[i]);
        }
        long res=-1;
        if(e1!=Integer.MAX_VALUE&&p2!=-1)
            res=Math.max(res,result-e1+p2);
        if(p1!=Integer.MAX_VALUE&&e2!=-1)
            res=Math.max(res,result-p1+e2);

        return res;
    }


}
