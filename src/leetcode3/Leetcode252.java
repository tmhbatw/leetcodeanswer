package leetcode3;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode252 {
    /*Description
    * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
    * 请你判断一个人是否能够参加这里面的全部会议。
    * */

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals==null||intervals.length==0)
            return true;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i-1][1])
                return false;
        }
        return true;
    }
}
