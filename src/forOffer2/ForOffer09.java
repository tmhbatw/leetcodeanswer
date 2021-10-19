package forOffer2;

public class ForOffer09 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result=0;
        int j=0;
        int cur=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=k){
                cur=1;
                j=i+1;
                continue;
            }
            while(j<nums.length&&cur*nums[j]<k){
                cur*=nums[j++];
            }
            result+=j-i;
            cur/=nums[i];
        }
        return result;
    }
}
