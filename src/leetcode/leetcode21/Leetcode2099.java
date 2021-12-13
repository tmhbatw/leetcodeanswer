package leetcode.leetcode21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2099 {

    public int[] maxSubsequence(int[] nums, int k) {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            list.add(new int[]{i,nums[i]});

        list.sort((o1,o2)->{
            return o2[1]-o1[1];
        });

        List<int[]> l=new ArrayList<>();
        for(int i=0;i<k;i++)
            l.add(list.get(i));

        l.sort((o1,o2)->{return o1[0]-o2[0];});
        int[] res=new int[k];
        for(int i=0;i<k;i++)
            res[i]=l.get(i)[1];
        return res;
    }
}
