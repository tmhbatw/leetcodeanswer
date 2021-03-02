package forOffer;

public class forOffer53_1 {
    /*Description
    * 统计一个数字在排序数组中出现的次数。
    * */

    public int search(int[] nums, int target) {
        int index=-1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target&&(mid==0||nums[mid-1]<target)){
                index=mid;
                break;
            }
            if(nums[mid]>=target)
                right=mid-1;
            else
                left=mid+1;
        }
        if(index==-1)
            return 0;
        left=0;right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target&&(mid==nums.length-1||nums[mid+1]>target)) {
                return mid - index + 1;
            }
            else if(nums[mid]<=target)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;
    }
}
