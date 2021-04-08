package leetcode.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode229 {
    /*Description
    *给定一个大小为n的整数数组，找出其中所有出现超过⌊ n/3 ⌋次的元素。
    * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
    * */

    public List<Integer> majorityElement(int[] nums) {
        int number1=Integer.MAX_VALUE,number2=Integer.MAX_VALUE;
        int count1=0,count2=0;
        for(int cur:nums){
            if(cur==number1)
                count1++;
            else if(cur==number2)
                count2++;
            else if(count1==0){
                number1=cur;
                count1=1;
            }
            else if(count2==0){
                number2=cur;
                count2=1;
            }else{
                count1--;
                if(count1==0)
                    number1=Integer.MAX_VALUE;
                count2--;
                if(count2==0)
                    number2=Integer.MAX_VALUE;
            }
        }
        int num1=0,num2=0;
        for(int cur:nums){
            if(cur==number1)
                num1++;
            if(cur==number2)
                num2++;
        }
        List<Integer> result=new ArrayList<>();
        if(num1*3>nums.length)
            result.add(number1);
        if(num2*3>nums.length)
            result.add(number2);
        return result;
    }

}
