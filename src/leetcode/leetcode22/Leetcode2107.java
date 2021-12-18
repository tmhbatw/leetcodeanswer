package leetcode.leetcode22;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2107 {

    public int shareCandies(int[] candies, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=k;i<candies.length;i++){
            map.put(candies[i],map.getOrDefault(candies[i],0)+1);
        }

        int result=map.size();
        if(k==0)
            return result;
        for(int i=k;i<candies.length;i++){
            map.put(candies[i],map.get(candies[i])-1);
            if(map.get(candies[i])==0)
                map.remove(candies[i]);
            map.put(candies[i-k],map.getOrDefault(candies[i-k],0)+1);
            result=Math.max(result,map.size());
        }
        return result;
    }
}
