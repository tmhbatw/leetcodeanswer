package leetcode.leetcode16;

import java.util.Arrays;
import java.util.TreeMap;

public class Leetcode1564 {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int[] min=new int[warehouse.length];
        int max=Integer.MAX_VALUE;
        for(int i=0;i<warehouse.length;i++){
            max=Math.min(max,warehouse[i]);
            min[i]=max;
        }

        Arrays.sort(boxes);
        int j=warehouse.length-1;
        int result=0;
        for (int box : boxes) {
            while (j >= 0 && min[j] < box)
                j--;
            if (j >= 0) {
                j--;
                result++;
            }
        }
        return result;
    }
}
