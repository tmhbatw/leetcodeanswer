package leetcode.leetcode16;

public class Leetcode1523 {


    public int countOdds(int low, int high) {
        if(low%2==1)
            return (high-low+2)/2;
        return (high-low+1)/2;

    }
}
