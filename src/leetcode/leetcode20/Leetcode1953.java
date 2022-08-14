package leetcode.leetcode20;

public class Leetcode1953 {

    public long numberOfWeeks(int[] milestones) {
        long max=0;
        long sum=0;
        for(int num:milestones){
            max=Math.max(max,num);
            sum+=num;
        }

        if(max*2>sum){
            return (sum-max)*2+1;
        }
        return sum;
    }
}
