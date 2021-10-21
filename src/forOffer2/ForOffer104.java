package forOffer2;

public class ForOffer104 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int cur:nums){
                if(i>=cur){
                    dp[i]+=dp[i-cur];
                }
            }
        }
        return dp[target];
    }
}
