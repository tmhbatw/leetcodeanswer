package leetcode.leetcode22;

public class Leetcode2145 {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min=0;
        long max=0;
        int cur=0;
        for(int diff:differences){
            cur+=diff;
            min=Math.min(cur,min);
            max=Math.max(cur,max);
        }


        max+=(lower-min);
        return (int) Math.max(0,(upper-max+1));
    }
}
