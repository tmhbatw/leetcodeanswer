package leetcode.leetcode10;

public class Leetcode977 {

    public int[] sortedSquares(int[] nums) {
        int[] res=new int[nums.length];

        int index1=0;
        for(;index1<nums.length;index1++){
            if(nums[index1]>=0)
                break;
        }

        int index2=index1-1;

        for(int i=0;i<res.length;i++){
            int val1=index1<nums.length?nums[index1]*nums[index1]:Integer.MAX_VALUE;
            int val2=index2>=0?nums[index2]*nums[index2]:Integer.MAX_VALUE;


            if(val1<val2) {
                res[i] =val1;
                index1++;
            }else{
                res[i]=val2;
                index2--;
            }
        }

        return res;

    }
}
