package lcp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class lcp11 {
    /*Description
    *
    * */
    public int expectNumber(int[] scores) {
        Set<Integer> set=new HashSet<>();
        for(int cur:scores)
            set.add(cur);
        return set.size();
    }

}
