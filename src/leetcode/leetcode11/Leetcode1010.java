package leetcode.leetcode11;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int result=0;
        int[] number=new int[60];
        for(int num:time){
            result+=number[getRes(num)];
            number[num%60]++;
        }
        return result;
    }

    private int getRes(int cur){
        if(cur%60==0)
            return 0;
        return 60-cur%60;
    }
}
