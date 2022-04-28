package leetcode.leetcode23;

public class Leetcode2214 {

    public long minimumHealth(int[] damage, int armor) {
        long result =1;
        int max = 0;
        for(int num:damage){
            max=Math.max(max,num);
            result+=num;
        }
        result -= Math.min(max,armor);
        return result;
    }
}
