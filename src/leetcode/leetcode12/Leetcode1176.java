package leetcode.leetcode12;

public class Leetcode1176 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum=0;
        for(int i=0;i<k-1;i++){
            sum+=calories[i];
        }
        int res=0;
        for(int i=k-1;i<calories.length;i++){
            sum+=calories[i];
            if(sum>upper)
                res++;
            if(sum<lower)
                res--;
            sum-=calories[i-k+1];
        }
        return res;
    }
}
