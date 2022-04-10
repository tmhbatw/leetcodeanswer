package leetcode.leetcode23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();

        for(int num:nums1)
            s1.add(num);

        for(int num:nums2)
            s2.add(num);

        Set<Integer> res1=new HashSet<>();
        Set<Integer> res2=new HashSet<>();

        for(int num1:s1){
            if(!s2.contains(nums1))
                res1.add(num1);
        }

        for(int num2:s2){
            if(!s1.contains(nums2))
                res2.add(num2);
        }

        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>(res1));
        result.add(new ArrayList<>(res2));
        return result;
    }
}
