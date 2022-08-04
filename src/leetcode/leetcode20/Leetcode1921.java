package leetcode.leetcode20;

import java.util.Arrays;

public class Leetcode1921 {


    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] t=new double[dist.length];
        for(int i=0;i<dist.length;i++)
            t[i]=dist[i]*1.0/speed[i];

        Arrays.sort(t);
        int max= (int) t[t.length-1];

        int count=0;
        int j=0;
        for(int i=0;i<=max;i++){
            if(j==dist.length||t[j]<=i)
                return count;
            count++;
            j++;
        }
        return count;
    }

}
