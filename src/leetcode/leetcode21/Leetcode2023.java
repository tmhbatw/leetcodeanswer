package leetcode.leetcode21;

public class Leetcode2023 {

    public int numOfPairs(String[] nums, String target) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j)
                    continue;
                if((nums[i]+nums[j]).equals(target))
                    result++;
            }
        }
        return result;
    }
}
