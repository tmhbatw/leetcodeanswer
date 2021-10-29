package leetcode.leetcode4;

import java.util.*;

public class Leetcode356 {
    double res=Double.MAX_VALUE;
    public boolean isReflected(int[][] points) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] point:points){
            map.putIfAbsent(point[1],new ArrayList<>());
            map.get(point[1]).add(point[0]);
        }

        for(List<Integer> list:map.values()){
            if(!getMid(list))
                return false;
        }
        return true;
    }

    private boolean getMid(List<Integer> l){
        Collections.sort(l);
        int left=0,right=l.size()-1;
        while(left<=right){
            if(left>=1&&l.get(left).equals(l.get(left-1))) {
                left++;
                continue;
            }
            if(right<=l.size()-2&& l.get(right).equals(l.get(right + 1))){
                right--;
                continue;
            }
            double cur=(l.get(left++)*1.0+l.get(right--))/2;
            if(res==Double.MAX_VALUE)
                res=cur;
            if(res!=cur)
                return false;
        }
        return true;
    }

}
