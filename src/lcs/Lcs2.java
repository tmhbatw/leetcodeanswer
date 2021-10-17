package lcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lcs2 {

    public int halfQuestions(int[] questions) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:questions)
            map.put(cur,map.getOrDefault(cur,0)+1);
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((o1,o2)->{
            return o2.getValue()-o1.getValue();
        });
        int cur=0;
        int res=0;
        int index=0;
        while(cur<questions.length/2){
            res++;
            cur+=list.get(index++).getValue();
        }
        return res;
    }
}
