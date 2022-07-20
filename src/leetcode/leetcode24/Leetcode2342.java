package leetcode.leetcode24;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2342 {

    public int maximumSum(int[] nums) {
        Map<Integer,int[]> map=new HashMap<>();
        int result=-1;

        for(int num:nums){
            int cur=getDigitSum(num);
            map.putIfAbsent(cur,new int[]{0,0});

            int[] digitSumArray=map.get(cur);
            if(num>digitSumArray[0]) {
                digitSumArray[1]=digitSumArray[0];
                digitSumArray[0]=num;
            }else if(digitSumArray[1]<num)
                digitSumArray[1]=num;

            if(digitSumArray[1]>0){
                result=Math.max(digitSumArray[0]+digitSumArray[1],result);
            }
        }

        return result;
    }

    private int getDigitSum(int num){
        int cur=0;
        while(num>0){
            cur+=num%10;
            num/=10;
        }

        return cur;
    }
}
