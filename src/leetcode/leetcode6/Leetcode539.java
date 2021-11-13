package leetcode.leetcode6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode539 {

    public int findMinDifference(List<String> timePoints) {
        List<Integer> list=new ArrayList<>();
        for(String time:timePoints)
            list.add(getTime(time));
        Collections.sort(list);
        int result=list.get(0)+1440-list.get(list.size()-1);
        for(int i=1;i<list.size();i++){
            result=Math.min(result,list.get(i)-list.get(i-1));
        }
        return result;
    }

    private int getTime(String time){
        String[] t=time.split(":");
        int h=Integer.parseInt(t[0]);
        int m=Integer.parseInt(t[1]);
        return h*60+m;
    }
}
