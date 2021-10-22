package forOffer2;

import java.util.TreeMap;
import java.util.TreeSet;

public class ForOffer57 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> map=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(map.ceiling(nums[i])!=null&&(long)map.ceiling(nums[i])-nums[i]<=t){
                return true;
            }
            if(map.floor(nums[i])!=null&&(long)nums[i]-map.floor(nums[i])<=t)
                return true;
            map.add(nums[i]);

            if(i>=k)
                map.remove(nums[i-k]);
        }
        return false;
    }
}
