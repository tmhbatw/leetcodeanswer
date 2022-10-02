package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2323 {

    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);

        int result=0;
        for(int i=0;i<jobs.length;i++){
            result=Math.max(result,(jobs[i]-1)/workers[i]+1);
        }

        return result;
    }


}
