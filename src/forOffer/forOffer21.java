package forOffer;

public class forOffer21 {
    /*Description
    * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * */

    public int[] exchange(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            if((nums[left]%2)==1)
                left++;
            else if((nums[right]&2)==0)
                right--;
            else{
                int temp=nums[left];
                nums[left++]=nums[right];
                nums[right--]=temp;
            }
        }
        return nums;
    }
}
