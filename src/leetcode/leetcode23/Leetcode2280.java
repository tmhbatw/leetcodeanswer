package leetcode.leetcode23;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode2280 {



    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(o -> o[0]));


        int result = 0;
        int length = stockPrices.length;
        for(int i=0;i<length;i++){
            if(i==length-1)
                break;
            while(i<length-2&&getK(stockPrices[i],stockPrices[i+1],stockPrices[i+2])) {
                i++;
            }
            result++;
        }

        return result;
    }

    private boolean getK(int[] point1,int[] point2,int[] point3){
        long k1 = (long)(point2[1]-point1[1])*(point3[0]-point2[0]);
        long k2= (long)(point3[1]-point2[1])*(point2[0]-point1[0]);
        return k1==k2;
    }


}
