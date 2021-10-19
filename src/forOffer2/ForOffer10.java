package forOffer2;

import java.util.HashMap;
import java.util.Map;

public class ForOffer10 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        int curSum=0;
        int result=0;
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];
            result+=map.getOrDefault(curSum-k,0);
            map.put(curSum,map.getOrDefault(curSum,0));
        }
        return result;
    }
}
