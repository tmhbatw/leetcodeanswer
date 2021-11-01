package leetcode.leetcode20;

public class Leetcode1966 {

    public int binarySearchableNumbers(int[] nums) {
        boolean[] result=new boolean[nums.length];

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<max)
                result[i]=true;
            else
                max=nums[i];
        }

        int min=Integer.MAX_VALUE;
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]>min)
                result[j]=true;
            else
                min=nums[j];
        }

        int res=0;
        for(boolean cur:result){
            res+=cur?0:1;
        }
        return res;
    }
}
