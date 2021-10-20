package forOffer2;

public class ForOffer90 {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        if(nums.length==3)
            return Math.max(nums[0],Math.max(nums[0],nums[1]));

        int[] res=new int[nums.length-1];
        res[0]=nums[0];
        res[1]=Math.max(nums[0],nums[1]);
        for(int j=2;j<nums.length-1;j++){
            res[j]=Math.max(res[j-2]+nums[j],res[j-1]);
        }

        int[] res2=new int[nums.length-1];
        res2[0]=nums[1];
        res2[1]=Math.max(nums[1],nums[2]);
        for(int j=2;j<nums.length-1;j++){
            res2[j]=Math.max(res2[j-2]+nums[j+1],res2[j-1]);
        }

        return Math.max(res[res.length-1],res2[res2.length-1]);
    }
}
