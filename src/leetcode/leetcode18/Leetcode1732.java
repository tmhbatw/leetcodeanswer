package leetcode.leetcode18;

public class Leetcode1732 {
    public int largestAltitude(int[] gain) {
        int res=0;
        int pre=0;
        for(int cur:gain){
            pre+=cur;
            res=Math.max(res,pre);
        }
        return res;
    }
}
