package leetcode.leetcode4;

import java.util.*;

public class Leetcode349 {
    /*Description
    *给定两个数组，编写一个函数来计算它们的交集。
     * */

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=changeToSet(nums1);
        Set<Integer> set2=changeToSet(nums2);
        List<Integer> list=new ArrayList<>();
        for(int cur:set1)
            if(set2.contains(cur))
                list.add(cur);
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++)
            result[i]=list.get(i);
        return result;
    }

    private Set<Integer> changeToSet(int[] nums){
        Set<Integer> set=new HashSet<>();
        for(int cur:nums)
            set.add(cur);
        return set;
    }
}
