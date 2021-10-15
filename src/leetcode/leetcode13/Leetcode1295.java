package leetcode.leetcode13;

public class Leetcode1295 {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int cur:nums){
            if((cur+"").length()%2==0)
                count++;
        }
        return count;
    }
}
