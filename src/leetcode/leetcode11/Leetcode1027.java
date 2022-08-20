package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1027 {

    public int longestArithSeqLength(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        List<Map<Integer,Integer>> l=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            l.add(new HashMap<>());
        }

        int result=2;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                int diff=nums[i]-nums[j];
                int pre=l.get(j).getOrDefault(diff,1);
                int cur=l.get(i).getOrDefault(diff,1);
                l.get(i).put(diff,Math.max(pre+1,cur));
                result=Math.max(result,l.get(i).get(diff));
            }
        }

        return result;
    }

}
