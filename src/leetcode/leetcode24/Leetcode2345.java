package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2345 {

    public int visibleMountains(int[][] peaks) {
        Arrays.sort(peaks,(o1,o2)->{
            if(o1[0]-o1[1]==o2[0]-o2[1])
                return o2[1]-o1[1];
            return o1[0]-o1[1]-o2[0]+o2[1];
        });

        int result=0;
        int right=Integer.MIN_VALUE;
        for(int i=0;i<peaks.length;i++){
            if(i<peaks.length-1&&peaks[i+1][0]==peaks[i][0]&&peaks[i+1][1]==peaks[i][1]){
                while(i<peaks.length-1&&peaks[i+1][0]==peaks[i][0]&&peaks[i+1][1]==peaks[i][1]){
                    i++;
                }
                right=Math.max(right,peaks[i][0]+peaks[i][1]);
                continue;
            }

            int r=peaks[i][0]+peaks[i][1];
            if(r>right){
                result++;
                right=r;
            }
        }
        return result;
    }


}
