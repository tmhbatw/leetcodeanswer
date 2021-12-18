package leetcode.leetcode16;

import java.util.Arrays;

public class Leetcode1580 {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int max=Integer.MAX_VALUE;
        int[] left=new int[warehouse.length];

        for(int i=0;i<warehouse.length;i++){
            max=Math.min(max,warehouse[i]);
            left[i]=max;
        }
        max=Integer.MAX_VALUE;
        int[] min=new int[warehouse.length];

        for(int j=warehouse.length-1;j>=0;j--){
            max=Math.min(max,warehouse[j]);
            min[j]=Math.max(left[j],max);
        }

        System.out.println(Arrays.toString(min));
        Arrays.sort(min);
        Arrays.sort(boxes);
        int j=0;
        int result=0;

        for (int box : boxes) {
            while (j < warehouse.length && min[j] < box)
                j++;
            if (j == warehouse.length)
                break;
            j++;
            result++;
        }

        return result;
    }
}
