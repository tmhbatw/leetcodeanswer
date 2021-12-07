package leetcode.leetcode17;

public class Leetcode1664 {

    public int waysToMakeFair(int[] nums) {
        int even=0;
        int odd=0;

        for(int i=0;i<nums.length;i++){
            if(i%2==0)
                even+=nums[i];
            else
                odd+=nums[i];
        }

        int preEven=0;
        int preOdd=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                even-=nums[i];
            }else
                odd-=nums[i];
            if(preEven+odd==preOdd+even)
                count++;

            if(i%2==0)
                preEven+=nums[i];
            else
                preOdd+=nums[i];
        }
        return count;
    }
}
