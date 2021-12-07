package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1272 {

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result=new ArrayList<>();
        for(int[] interval:intervals){
            if(interval[1]<=toBeRemoved[0]||interval[0]>=toBeRemoved[1]){
                result.add(getList(interval));
                continue;
            }
            if(interval[1]<=toBeRemoved[1]&&interval[0]>=toBeRemoved[0])
                continue;
            if(interval[0]<toBeRemoved[0]){
                if(interval[1]>toBeRemoved[1]){
                    result.add(getList(new int[]{interval[0],toBeRemoved[0]}));
                    interval[0]=toBeRemoved[1];
                }else{
                    interval[1]=toBeRemoved[0];

                }
            }else{
                interval[0]=toBeRemoved[1];
            }
            result.add(getList(interval));
        }
        return result;
    }

    private List<Integer> getList(int[] i){
        List<Integer> list=new ArrayList<>();
        list.add(i[0]);
        list.add(i[1]);
        return list;
    }


}
