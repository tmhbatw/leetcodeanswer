package leetcode.leetcode8;

import java.util.HashMap;
import java.util.Map;

public class Leetcode781 {

    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map=new HashMap<>();
        int result=0;

        for(int num:answers){
            map.putIfAbsent(num,0);
            map.put(num,map.get(num)+1);
        }
        for(int key:map.keySet()){
            int time=(map.get(key)-1)/(key+1)+1;
            result+=time*(key+1);
        }
        return result;
    }

}
