package leetcode.leetcode21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Leetcode2008 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        TreeMap<Integer,Long> map=new TreeMap<>();
        Arrays.sort(rides, Comparator.comparingInt(o -> o[0]));

        map.put(0, 0L);
        for(int[] ride:rides) {
            //System.out.println(Arrays.toString(ride));
            long pre = map.get(map.floorKey(ride[0]));
            long cur = pre+ride[1]-ride[0]+ride[2];

            if(map.get(map.floorKey(ride[1]))>=cur)
                continue;
            map.put(ride[1],cur);
            int curr=ride[1]+1;
            while(map.ceilingKey(curr)!=null&&map.get(map.ceilingKey(curr))<cur){
                // System.out.println(map.ceilingKey(curr));
                curr = map.ceilingKey(curr);
                map.remove(curr);
            }
            //System.out.println(map);

        }

        return map.get(map.lastKey());
    }
}
