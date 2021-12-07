package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1333 {

    public List<Integer> filterRestaurants(int[][] restaurants,
                                           int veganFriendly,
                                           int maxPrice,
                                           int maxDistance) {
        List<int[]> list=new ArrayList<>();
        for(int[] cur:restaurants){
            if(cur[2]>=veganFriendly&&cur[3]<=maxPrice&&cur[4]<=maxDistance)
                list.add(cur);
        }

        list.sort((o1, o2) -> {
            if(o2[1]==o1[1])
                return o2[0]-o1[0];
            return o2[1] - o1[1];
        });

        List<Integer> result=new ArrayList<>();
        for(int[] l:list)
            result.add(l[0]);
        return result;
    }
}
