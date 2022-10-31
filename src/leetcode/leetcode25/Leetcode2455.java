package leetcode.leetcode25;

public class Leetcode2455 {

    public int averageValue(int[] nums) {
        int result=0;
        int count=0;
        for(int num:nums){
            if(num%6==0){
                count++;
                result+=num;
            }
        }
        return count==0?0:result/count;
    }


}
