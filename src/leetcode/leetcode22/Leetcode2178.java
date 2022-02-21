package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2178 {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result=new ArrayList<>();
        if(finalSum%2==1)
            return result;

        long cur=2;
        while(finalSum>cur*2){
            finalSum-=cur;
            result.add(cur);
            cur+=2;
        }

        result.add(finalSum);
        return result;
    }
}
