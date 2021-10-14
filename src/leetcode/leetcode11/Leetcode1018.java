package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1018 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        int pre=0;
        List<Boolean> list=new ArrayList<>();
        for(int cur:nums){
            pre=pre*2+cur;
            if(pre%5==0)
                list.add(true);
            else
                list.add(false);
            pre%=5;
        }
        return list;
    }
}
