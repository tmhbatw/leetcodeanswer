package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1686 {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[][] value=new int[aliceValues.length][2];
        for(int i=0;i<aliceValues.length;i++) {
            value[i][0] = i;
            value[i][1] = aliceValues[i]+bobValues[i];
        }
        Arrays.sort(value,(o1,o2)->{
            return o2[1]-o1[1];
        });

        int result=0;
        for(int i=0;i<value.length;i++){
            if(i%2==0){
                result+=aliceValues[value[i][0]];
            }else
                result-=bobValues[value[i][0]];
        }
        return Integer.compare(result,0);
    }


}
