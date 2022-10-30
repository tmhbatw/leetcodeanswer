package leetcode.leetcode25;

public class Leetcode2447 {

    public int subarrayGCD(int[] nums, int k) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            if(cur==k){
                result++;
            }else if(cur%k!=0){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                cur=gcd(cur,nums[j]);
                if(cur==k){
                    result++;
                }else if(cur%k!=0){
                    break;
                }
            }
        }
        return result;
    }

    private int gcd(int max,int min){
        if(max%min==0)
            return min;
        return gcd(min,max%min);
    }


}
