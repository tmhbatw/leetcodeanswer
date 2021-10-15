package leetcode.leetcode13;

public class Leetcode1217 {
    public int minCostToMoveChips(int[] position) {
        int odd=0,even=0;
        for(int cur:position){
            if(cur%2==0)
                odd++;
            else
                even++;
        }
        return Math.min(odd,even);
    }
}
