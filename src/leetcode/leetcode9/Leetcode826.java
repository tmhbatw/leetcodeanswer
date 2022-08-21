package leetcode.leetcode9;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode826 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] arr=new int[difficulty.length][2];
        for(int i=0;i<difficulty.length;i++){
            arr[i][0]=difficulty[i];
            arr[i][1]=profit[i];
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(worker);

        int result =0;
        int j=0;
        int max=0;
        for (int k : worker) {
            if (k < arr[0][0])
                continue;

            while (j < arr.length && arr[j][0] <= k) {
                max = Math.max(arr[j++][1], max);
            }
            result += max;
        }

        return result;
    }


}
