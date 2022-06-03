package leetcode.leetcode23;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode2285 {

    public long maximumImportance(int n, int[][] roads) {
        int[] time=new int[n];
        for(int[] road:roads){
            time[road[0]]++;
            time[road[1]]++;
        }

        Arrays.sort(time);
        long result =0;
        for(int i=time.length-1;i>=0;i--){
            result +=(long)(n)*time[i];
            n--;
        }

        return result ;
    }
}
