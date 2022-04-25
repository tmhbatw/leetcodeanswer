package leetcode.leetcode23;

import java.util.*;

public class Leetcode2248 {

    public List<Integer> intersection(int[][] nums) {
        Set<Integer> result=new HashSet<>();
        for(int num:nums[0])
            result.add(num);

        for(int i=1;i<nums.length;i++){
            Set<Integer> set=new HashSet<>();
            for(int num:nums[i]){
                if(result.contains(num))
                    set.add(num);
            }
            result=set;
        }

        List<Integer> res=new ArrayList<>(result);
        Collections.sort(res);
        return res;
    }


}
