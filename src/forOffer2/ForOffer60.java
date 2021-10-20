package forOffer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForOffer60 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:nums){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((o1,o2)->{
            if(o1.getValue().equals(o2.getValue()))
                return o1.getKey()-o2.getKey();
            return o2.getValue()-o1.getValue();
        });
        int[] res=new int[k];
        for(int i=0;i<k;i++)
            res[i]=list.get(i).getKey();
        return res;
    }
}
