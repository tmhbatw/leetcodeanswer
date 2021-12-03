package leetcode.leetcode17;

public class Leetcode1685 {


    public int[] getSumAbsoluteDifferences(int[] nums) {
        int length=nums.length;
        int[] res=new int[length];

        int cur=0;
        for(int i=1;i<length;i++)
            cur+=nums[i]-nums[0];
        res[0]=cur;

        for(int i=1;i<length;i++){
            cur+=(2*i-length)*(nums[i]-nums[i-1]);
            res[i]=cur;
        }

        return res;
    }
}
