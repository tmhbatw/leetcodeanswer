package leetcode.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode334 {
    /*Description
    * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
    * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，
    * 返回 true ；否则，返回 false 。
    * */

    public boolean increasingTriplet(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int number=0;
        for(int cur:nums){
            if(number==0||cur>list.get(number-1)){
                list.add(cur);
                number++;
                if(number==3)
                    return true;
            }else {
                if(list.get(0)>cur){
                    list.set(0,cur);
                }else if(number==2&&list.get(0)<cur&&list.get(1)>cur)
                    list.set(1,cur);
            }
        }
        return false;
    }
}
