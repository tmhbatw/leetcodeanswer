package leetcode.leetcode4;

public class Leetcode376 {

    public int wiggleMaxLength(int[] nums) {
        int result=0;
        int up=1;
        int down=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                up=Math.max(up,down+1);
            }
            if(nums[i]<nums[i-1]){
                down=Math.max(down,up+1);
            }
        }
        return Math.max(up,down);
    }
}
