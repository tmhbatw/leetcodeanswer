package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    /*Description
    * 给出一个区间的集合，请合并所有重叠的区间
     * */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        List<int[]> result=new ArrayList<>();
        int length= intervals.length;
        for(int i=0;i<length;i++){
            int[] curInterval=intervals[i];
            while(i<length-1&&intervals[i+1][0]<=curInterval[1]){
                curInterval[1]=Math.max(curInterval[1],intervals[++i][1]);
            }
            result.add(curInterval);
        }
        int[][] res=new int[result.size()][2];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        return res;
    }


}
