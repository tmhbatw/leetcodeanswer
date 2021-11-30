package leetcode.leetcode21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2085 {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res=0;
        for(int i=0;i<seats.length;i++)
            res+=Math.abs(seats[i]-students[i]);
        return res;
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map1=getMap(words1);
        Map<String,Integer> map2=getMap(words2);

        int result=0;
        for(String key:map1.keySet()){
            if(map1.get(key)==1&&map2.getOrDefault(key,0)==1)
                result++;
        }
        return result;
    }

    private Map<String,Integer> getMap(String[] word){
        Map<String,Integer> map=new HashMap<>();
        for(String cur:word){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        return map;
    }
}
