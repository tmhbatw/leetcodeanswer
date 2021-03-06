package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem16_24 {
    /*Description
    *设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
    * */

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                List<Integer> list=new ArrayList<>();
                list.add(nums[left++]);
                list.add(nums[right--]);
                result.add(list);
            }else if(nums[left]+nums[right]>target){
                right--;
            }else
                left++;
        }
        return result;
    }
}
