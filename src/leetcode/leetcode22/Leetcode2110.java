package leetcode.leetcode22;

public class Leetcode2110 {

    public long getDescentPeriods(int[] prices) {
        long result=0;

        int pre=0;
        int time=1;

        for(int price:prices){
            if(pre-1==price){
                time++;
            }
            else{
                time=1;
            }
            pre=price;
            result+=time;
        }

        return result;
    }
}
