package leetcode.leetcode14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode1346 {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int cur:arr)
            set.add(cur);
        int count0=0;
        for(int cur:arr){
            if(cur==0) {
                count0++;
                continue;
            }
            if(set.contains(cur*2))
                return true;
        }
        return count0>=2;
    }
}
