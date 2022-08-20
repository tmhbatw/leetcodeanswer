package leetcode.leetcode8;

public class Leetcode775 {

    public boolean isIdealPermutation(int[] nums) {
        int count = getRes(nums.clone(),0,nums.length-1);

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])
                count--;
        }

        return count==0;
    }

    private int getRes(int[] nums,int i,int j){
        if(i>=j)
            return 0;
        int mid=(i+j)/2;
        int cur=getRes(nums,i,mid)+getRes(nums,mid+1,j);
        int[] num=new int[j-i+1];

        int ii=i,jj=mid+1;
        for(int index=0;index<num.length;index++){
            int num1=ii<=mid?nums[ii]:Integer.MAX_VALUE;
            int num2=jj<=j?nums[jj]:Integer.MAX_VALUE;

            if(num1<=num2){
                num[index]=nums[ii++];
            }else{
                num[index]=nums[jj++];
                cur+=(mid-ii+1);
            }
        }
        System.arraycopy(num, 0, nums, i , num.length);

        return cur;
    }
}
