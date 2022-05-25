package leetcode.leetcode23;

import java.util.Arrays;

public class Leetcode2274 {

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        if(special.length==0){
            return top-bottom+1;
        }
        int result = Math.max(0,special[0]-bottom);

        int pre = bottom;
        for(int num:special){
            if(num>top) {
                result = Math.max(result,top-num);
                break;
            }
            result =Math.max(num-pre-1,result);
            pre = num;
        }

        result =Math.max(top-special[special.length-1],result);
        return result;
    }
}
