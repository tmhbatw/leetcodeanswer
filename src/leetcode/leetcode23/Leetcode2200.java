package leetcode.leetcode23;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2200 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result=new ArrayList<>();
        int pre=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key) {
                int start=Math.max(pre,i-k);
                int end=Math.min(i+k,nums.length-1);

                for(int j=start;j<=end;j++){
                    result.add(j);
                }
                pre=end+1;
            }
        }

        return result;
    }
}
