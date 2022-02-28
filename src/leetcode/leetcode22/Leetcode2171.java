package leetcode.leetcode22;

import java.util.Arrays;

public class Leetcode2171 {

    public long minimumRemoval(int[] beans) {
        long result=Long.MAX_VALUE;
        Arrays.sort(beans);

        long sum=0;
        for(int bean:beans){
            sum+=bean;
        }

        for(int i=0;i<beans.length;i++){
            result=Math.min(result,sum-(long)beans[i]*(beans.length-i));
        }

        return result;
    }
}
