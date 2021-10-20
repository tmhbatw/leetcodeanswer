package forOffer2;

import java.util.*;

public class ForOffer119 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int cur:nums)
            set.add(cur);
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        if(list.size()==0)
            return 0;

        int result=1;
        int[] res=new int[list.size()];
        res[0]=1;
        for(int i=1;i<res.length;i++){
            if(list.get(i)-list.get(i-1)==1)
                res[i]=res[i-1]+1;
            else
                res[i]=1;
            result=Math.max(result,res[i]);
        }
        return result;
    }
}
