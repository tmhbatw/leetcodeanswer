package leetcode.leetcode20;

import java.util.Arrays;

public class Leetcode1981 {

    public int minimizeTheDifference(int[][] mat, int target) {
        int max=0;
        for(int[] m:mat){
            max+= Arrays.stream(m).max().getAsInt();
        }
        boolean[] reached=new boolean[max+1];
        reached[0]=true;

        for(int i=0;i<mat.length;i++){
            boolean[] curReached=new boolean[max+1];
            for(int cur:mat[i]){
                for(int j=0;j<reached.length;j++){
                    if(reached[j]){
                        curReached[j+cur]=true;
                    }
                }
            }
            reached=curReached;
        }

        int result=Integer.MAX_VALUE;
        for(int i=0;i<reached.length;i++){
            if(reached[i]){
                result=Math.min(result,Math.abs(i-target));
            }
        }

        return result;
    }

}
