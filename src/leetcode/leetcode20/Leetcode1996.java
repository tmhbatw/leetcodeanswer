package leetcode.leetcode20;

import java.util.TreeMap;

public class Leetcode1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int[] p:properties){
            Integer bigKey=map.ceilingKey(p[0]);
            if(bigKey!=null&&map.get(bigKey)>=p[1])
                continue;

            Integer lowerKey=map.lowerKey(p[0]);
            while(lowerKey!=null&&map.get(lowerKey)<p[1]){
                map.remove(lowerKey);
                lowerKey=map.lowerKey(lowerKey);
            }
            map.put(p[0],p[1]);
        }

        //System.out.println(map);

        int result=0;
        for(int[] p:properties){
            Integer bigKey=map.higherKey(p[0]);
            if(bigKey!=null&&map.get(bigKey)>p[1])
                result++;
        }
        return result;
    }
}
