package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        list.add(-1);

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1)
                list.add(i);
        }

        if(list.size()<=k)
            return 0;
        list.add(nums.length);
        int result=0;
        for(int i=1;i<list.size()-k;i++){
            result+=(list.get(i)-list.get(i-1))*(list.get(i+k)-list.get(i+k-1));
        }
        return result;
    }
}
