package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            map.putIfAbsent(groupSizes[i],new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int key:map.keySet()){
            List<Integer> list=map.get(key);
            for(int i=0;i<list.size();i+=key){
                List<Integer> cur=new ArrayList<>();
                for(int j=0;j<key;j++){
                    cur.add(list.get(i+j));
                }
                result.add(cur);
            }
        }
        return result;
    }
}
