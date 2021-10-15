package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1313 {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            for(int j=0;j<nums[i];j++)
                result.add(nums[i+1]);
        }
        int[] res=new int[result.size()];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        return res;
    }
}
