package leetcode.leetcode17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=l[i];j<=r[i];j++)
                list.add(nums[j]);
            Collections.sort(list);
            if(list.size()<=1) {
                result.add(true);
                continue;
            }
            int diff=list.get(1)-list.get(0);
            boolean isMatch=true;
            for(int k = 2; k<list.size(); k++){
                if (list.get(i) - list.get(i - 1) != diff) {
                    isMatch = false;
                    break;
                }
            }
            result.add(isMatch);
        }
        return result;
    }
}
