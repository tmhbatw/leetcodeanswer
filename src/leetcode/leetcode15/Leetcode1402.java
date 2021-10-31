package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1402 {

    public int maxSatisfaction(int[] satisfaction) {
        int[] sum=new int[satisfaction.length+1];
        Arrays.sort(satisfaction);

        int result=0;
        for(int i=0;i<satisfaction.length;i++){
            sum[i+1]=sum[i]+satisfaction[i];
        }

        for(int i=0;i<satisfaction.length;i++){
            if(satisfaction[i]+sum[satisfaction.length]-sum[i+1]>=0){
                result+=satisfaction[i]+sum[satisfaction.length]-sum[i+1];
            }
        }
        return result;
    }
}
