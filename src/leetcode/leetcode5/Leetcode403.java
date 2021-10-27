package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode403 {

    public boolean canCross(int[] stones) {
        if(stones[1]!=1)
            return false;
        List<Set<Integer>> result=new ArrayList<>();
        for(int i=0;i<stones.length;i++){
            result.add(new HashSet<>());
        }
        result.get(1).add(1);

        for(int i=2;i<stones.length;i++){
            for(int j=1;j<i;j++){
                int distance=stones[i]-stones[j];
                Set<Integer> set=result.get(j);
                if(set.contains(distance)||set.contains(distance-1)
                        ||set.contains(distance+1)){
                    result.get(i).add(distance);
                }
            }
        }

        return result.get(stones.length-1).size()>0;
    }
}
