package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    /*Description
    *给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？
    * 找出所有满足条件且不重复的四元组。
    * 注意：
    * 答案中不可以包含重复的四元组。
    * */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<length-3;i++){
            int cur1=nums[i];
            for(int j=i+1;j<length-2;j++){
                int cur2=nums[j];
                int curTarget=target-cur2-cur1;
                int left=j+1,right=length-1;
                while(left<right){
                    if(nums[left]+nums[right]<curTarget)
                        left++;
                    else if(nums[left]+nums[right]>curTarget){
                        right--;
                    }else{
                        List<Integer> cur=new ArrayList<>();
                        cur.add(cur1);
                        cur.add(cur2);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        result.add(cur);
                        while(left<right&&nums[left+1]==nums[left])
                            left++;
                        while(left<right&&nums[right-1]==nums[right])
                            right--;
                        left++;
                        right--;
                    }
                }
                while(j<length-1&&nums[j+1]==cur2)
                    j++;
            }
            while(i<length-1&&nums[i+1]==cur1)
                i++;
        }
        return result;
    }
}
