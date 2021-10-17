package forOffer2;

public class ForOffer68 {
    public int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1])
            return nums.length;
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]<target)
                l=mid+1;
            else
                r=mid;
        }
        return l;
    }
}
