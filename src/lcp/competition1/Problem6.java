package lcp.competition1;

public class Problem6 {
    /*
    *
    * */

    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        for(int cur:nums){
            sum+=cur;
        }
        if(sum==goal)
            return 0;
        if(sum>goal){
            return (int)((sum-goal-1)/limit+1);
        }
        else
            return (int)((goal-sum-1)/limit+1);

    }
}
