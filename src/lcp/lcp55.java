package lcp;

public class lcp55 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int result=0;
        for(int[] f:fruits){
            int t = (f[1]-1)/limit+1;
            result+=t*time[f[0]];
        }

        return result;
    }
}
