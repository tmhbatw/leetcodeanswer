package leetcode.leetcode9;

import java.util.HashSet;
import java.util.Set;

public class Leetcode822 {

    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]==backs[i])
                set.add(fronts[i]);
        }

        int result=Integer.MAX_VALUE;
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]!=backs[i]){
                if(!set.contains(fronts[i]))
                    result=Math.min(result,fronts[i]);
                if(!set.contains(backs[i]))
                    result=Math.min(result,backs[i]);
            }
        }

        return result==Integer.MAX_VALUE?0:result;
    }

}
