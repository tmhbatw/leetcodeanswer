package leetcode.leetcode18;

import java.util.Arrays;

public class Leetcode1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(o1,o2)->{
            return o2[1]-o1[1];
        });
        int result=0;
        for(int i=0;i<boxTypes.length&&truckSize>0;i++){
            int time=Math.min(truckSize,boxTypes[i][0]);
            result+=time*boxTypes[i][1];
            truckSize-=time;
        }
        return result;
    }
}
