package forOffer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForOffer75 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }
        List<Integer> list=new ArrayList<>();
        for(int cur:arr1)
            list.add(cur);
        list.sort((o1,o2)->{
            int val1=map.getOrDefault(o1,Integer.MAX_VALUE);
            int val2=map.getOrDefault(o2,Integer.MAX_VALUE);
            if(val1==val2)
                return o1-o2;
            return val1-val2;
        });
        for(int i=0;i<arr1.length;i++)
            arr1[i]=list.get(i);
        return arr1;
    }
}
