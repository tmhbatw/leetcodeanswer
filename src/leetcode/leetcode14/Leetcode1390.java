package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1390 {

    public int sumFourDivisors(int[] nums) {
        int result=0;
        for(int num:nums){
            result+=getRes(num);
        }
        return result;
    }

    private int getRes(int num){
        if(num<=4)
            return 0;
        int res=0;
        boolean exist=false;
        if(num%2==0){
            res+=2+num/2;
            exist=true;
        }
        for(int i=3;i<=Math.sqrt(num);i++){
            if(i*i==num)
                return 0;
            if(num%i==0){
                if(exist)
                    return 0;
                exist=true;
                res+=i+num/i;
            }
        }
        return exist?res+num+1:0;
    }

}
