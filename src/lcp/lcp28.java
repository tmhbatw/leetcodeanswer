package lcp;

import java.util.Arrays;

public class lcp28 {
    /*Description
    * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，
    * 要求购买零件的花费不超过预算，请问他有多少种采购方案。
    * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
    * */


    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;
        int mod=1000000007;
        int left=0,right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]<=target){
                result+=right-left;
                result%=mod;
                left++;
            }else{
                right--;
            }
        }
        return result;
    }
}
