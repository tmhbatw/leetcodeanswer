package forOffer2;

public class ForOffer88 {

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0)
            return 0;
        if(cost.length==1)
            return cost[0];
        int[] res=new int[cost.length+1];
        for(int i=2;i<=cost.length;i++){
            res[i]=Math.min(res[i-2]+cost[i-2],res[i-1]+cost[i-1]);
        }
        return res[cost.length];
    }
}
