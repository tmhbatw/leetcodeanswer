package leetcode.leetcode23;

public class Leetcode2239 {

    public int findClosestNumber(int[] nums) {
        int result=Integer.MAX_VALUE;
        int dif=result;
        for(int num:nums){
            int diff=num>0?num:-num;
            if(dif>diff||dif==diff&&result<0){
                result=num;
                dif=diff;
            }
        }
        return result;
    }
}
