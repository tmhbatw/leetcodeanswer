package leetcode.leetcode21;

import java.util.Arrays;

public class Leetcode2028 {


    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        for(int num:rolls){
            sum+=num;
        }

        int diff=mean*(n+rolls.length)-sum;
        if(diff<n||diff>6*n)
            return new int[]{};

        int small=diff/n;
        int bigCount=diff-small*n;
        int[] result=new int[n];
        Arrays.fill(result,small);

        for(int i=0;i<bigCount;i++){
            result[i]++;
        }

        return result;
    }


}
