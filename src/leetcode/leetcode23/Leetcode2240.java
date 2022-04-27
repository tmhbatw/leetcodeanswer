package leetcode.leetcode23;

public class Leetcode2240 {

    //（首项+末项）*系数/2
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long result = 0;
        if(cost1<cost2){
            int temp = cost1;
            cost1 = cost2;
            cost2 = temp;
        }

        int cur= total;
        for(int i=0;i<=total/cost1; i++){
            result += cur/cost2 +1;
            cur -= cost1;
        }
        return result;
    }
}
