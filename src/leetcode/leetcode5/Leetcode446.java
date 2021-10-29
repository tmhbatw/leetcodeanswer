package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode446 {

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2)
            return 0;

        List<Map<Long,Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(new HashMap<>());
        }

        list.get(1).put((long)nums[1]-nums[0],1);
        int result=0;
        for(int i=2;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int count=list.get(j).getOrDefault((long)nums[i]-nums[j],0);
                result+=count;
                list.get(i).put((long)nums[i]-nums[j],list.get(i).getOrDefault((long)nums[i]-nums[j],0)+1+count);
            }
        }


        return result;
    }
}
