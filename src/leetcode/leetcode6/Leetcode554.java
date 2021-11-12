package leetcode.leetcode6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode554 {

    public int leastBricks(List<List<Integer>> wall) {
        int sum=0;
        for(int cur:wall.get(0))
            sum+=cur;

        Map<Integer,Integer> count=new HashMap<>();
        for(List<Integer> list:wall){
            int cur=0;
            for(int i=0;i<list.size()-1;i++){
                cur+=list.get(i);
                count.put(cur,count.getOrDefault(cur,0)+1);
            }
        }

        int max=0;
        for(int num:count.keySet()){
            max=Math.max(max,count.get(num));
        }

        return wall.size()-max;
    }
}
