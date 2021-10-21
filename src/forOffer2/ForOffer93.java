package forOffer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForOffer93 {

    public int lenLongestFibSubseq(int[] arr) {
        List<Map<Integer,Integer>> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            list.add(new HashMap<>());

        int res=0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                int cur=list.get(j).getOrDefault(arr[i]-arr[j],0);
                res=Math.max(res,cur+2);
                list.get(i).put(arr[j],cur+1);
            }
        }

        return res<=2?0:res;
    }
}
