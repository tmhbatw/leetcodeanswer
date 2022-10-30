package leetcode.leetcode25;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2452 {

    public int destroyTargets(int[] nums, int space) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> small=new HashMap<>();

        for(int num:nums){
            int cur=num%space;
            map.put(cur,map.getOrDefault(cur,0)+1);
            int curSmall=small.getOrDefault(cur,Integer.MAX_VALUE);
            if(num<curSmall)
                small.put(cur,num);
        }

        int max=0;
        int result=0;
        for(int key:map.keySet()){
            if(map.get(key)>max||map.get(key)==max&&small.get(key)<result){
                max=map.get(key);
                result=small.get(key);
            }
        }
        return result;
    }

}
