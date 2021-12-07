package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Leetcode729 {
    class MyCalendar {

        List<int[]> list;
        public MyCalendar() {
            this.list=new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for(int[] cur:list){
                if(start>=cur[1]||end<=cur[0])
                    continue;
                return false;
            }
            list.add(new int[]{start,end});
            return true;
        }
    }
}
