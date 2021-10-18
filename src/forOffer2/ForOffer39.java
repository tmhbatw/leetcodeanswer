package forOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForOffer39 {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        List<Integer> l1=getList(source);
        List<Integer> l2=getList(target);

        int index=0;
        int miss=0;
        for (Integer integer : l1) {
            while (index < l2.size() && l2.get(index) < integer)
                index++;
            if (index == l2.size() || !l2.get(index).equals(integer))
                miss++;
            else
                index++;
        }
        return miss;
    }

    private List<Integer> getList(int[][] source){
        List<Integer> list=new ArrayList<>();
        for(int[] cur:source){
            for(int num:cur)
                list.add(num);
        }
        Collections.sort(list);
        return list;
    }
}
