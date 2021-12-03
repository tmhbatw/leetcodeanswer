package leetcode.leetcode18;

public class Leetcode1746 {

    public int maxSumAfterOperation(int[] nums) {
        int result=0;
        int n1=0;
        int n2=0;

        for(int num:nums){
            n1=Math.max(n1+num,n2+num*num);
            n2=Math.max(n2+num,0);

            result=Math.max(result,n1);
        }
        return result;
    }
}
