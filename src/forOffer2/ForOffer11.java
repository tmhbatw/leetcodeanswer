package forOffer2;

import java.util.HashMap;
import java.util.Map;

public class ForOffer11 {

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int result=0;
        int cur=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
                cur+=1;
            else
                cur-=1;
            if(map.containsKey(cur))
                result=Math.max(result,i-map.get(cur));
            else
                map.put(cur,i);
        }
        return result;
    }
}
