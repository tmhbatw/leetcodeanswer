package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode473 {

    boolean result=false;
    public boolean makesquare(int[] matchsticks) {
        int sum= Arrays.stream(matchsticks).sum();
        if(sum%4!=0)
            return false;
        sum/=4;
        dfs(matchsticks,0,new int[4],sum);
        return result;
    }

    private void dfs(int[] matchsticks,int index,int[] sum,int target){
        if(index==matchsticks.length){
            result=true;
        }

        if(result)
            return;

        for(int i=0;i<4;i++){
            if(sum[i]+matchsticks[index]<=target){
                sum[i]+=matchsticks[index];
                dfs(matchsticks,index+1,sum,target);
                sum[i]-=matchsticks[index];
            }
        }
    }
}
