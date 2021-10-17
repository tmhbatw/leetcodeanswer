package forOffer2;

import java.util.Arrays;

public class ForOffer101  {

    public boolean canPartition(int[] nums) {
        int sum= Arrays.stream(nums).sum();
        if(sum%2==1)
            return false;
        boolean[] res=new boolean[sum/2+1];
        res[0]=true;
        for(int cur:nums){
            for(int j=sum/2;j>=cur;j--){
                if(res[j-cur])
                    res[j]=true;
            }
        }
        return res[sum/2];
    }
}
