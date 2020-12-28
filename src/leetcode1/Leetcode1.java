package leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {
    /*Description
    * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    * 来源：力扣（LeetCode）
    * 链接：https://leetcode-cn.com/problems/two-sum
    * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int length=nums.length;
        for(int i=length-1;i>=0;i--){
            map.put(nums[i],i);
        }
        for(int i=0;i<length;i++){
            int curTarget=target-nums[i];
            if(map.containsKey(curTarget)&&map.get(curTarget)!=i){
                int result=map.get(curTarget);
                return new int[]{Math.min(result,i),Math.max(result,i)};
            }
        }
        return null;
    }
}
