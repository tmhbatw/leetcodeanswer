package leetcode.leetcode11;

public class Leetcode1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int length=customers.length;
        int[] sum1=new int[length+1];
        int[] sum2=new int[length+1];
        for(int i=0;i<length;i++) {
            sum1[i + 1] = sum1[i] + customers[i];
            sum2[i+1]=sum2[i];
            if(grumpy[i]==0)
                sum2[i+1]+=customers[i];
        }

        int result=0;
        for(int i=0;i<=length-minutes;i++){
            result=Math.max(result,sum1[i+minutes]-sum1[i]
                    +sum2[i]+sum2[length]-sum2[i+minutes]);
        }
        return result;
    }
}
