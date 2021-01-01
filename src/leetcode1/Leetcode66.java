package leetcode1;

import java.util.Arrays;

public class Leetcode66 {
    /*Description
    *给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
    * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    * 你可以假设除了整数 0 之外，这个整数不会以零开头。
    * */

    public int[] plusOne(int[] digits) {
        int count=1;
        for(int j=digits.length-1;j>=0;j--){
            digits[j]+=count;
            count=digits[j]/10;
            if(count==0)
                return digits;
            digits[j]%=10;
        }
        int[] result=new int[digits.length+1];
        result[0]=1;
        return result;
    }

}
