package leetcode.leetcode23;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }

        int result = 0;
        for(int key:map.keySet()){
            if(map.get(key)==1)
                return -1;
            result+= (map.get(key)+2)/3;
        }

        return result;
    }
}
