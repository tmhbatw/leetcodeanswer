package leetcode.leetcode20;

public class Leetcode1908 {

    public boolean nimGame(int[] piles) {
        int res=0;
        for(int num:piles)
            res^=num;
        return res!=0;
    }
}
