package forOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForOffer74 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->{
            return o1[0]-o2[0];
        });
        List<int[]> result=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];

            while(i<intervals.length-1&&intervals[i+1][0]<=end){
                i++;
                end=Math.max(end,intervals[i][1]);
            }

            result.add(new int[]{start,end});
        }

        int[][] res=new int[result.size()][2];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);

        return res;
    }
}
