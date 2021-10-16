package leetcode.leetcode19;

public class Leetcode1822 {

    public int arraySign(int[] nums) {
        boolean flag=true;
        for(int cur:nums){
            if(cur==0)
                return 0;
            if(cur<0)
                flag=!flag;
        }
        return flag?1:-1;
    }
}
