package leetcode.leetcode16;

public class Leetcode1578 {

    public int minCost(String s, int[] cost) {

        int result=0;
        int length=s.length();

        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            int sum=cost[i];
            int max=cost[i];
            while(i<length-1&&s.charAt(i+1)==cur){
                sum+=cost[i+1];
                max=Math.max(cost[++i],max);
            }

            result+=sum-max;
        }

        return result;
    }
}
