package leetcode.leetcode19;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1865 {

    class FindSumPairs {
        int[] num1;
        int[] num2;
        Map<Integer,Integer> map=new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.num1=nums1;
            this.num2=nums2;
            for(int num:nums2)
                map.put(num,map.getOrDefault(num,0)+1);
        }

        public void add(int index, int val) {
            map.put(num2[index],map.get(num2[index])-1);
            num2[index]+=val;
            map.put(num2[index],map.getOrDefault(num2[index],0)+1);
        }

        public int count(int tot) {
            int res=0;
            for(int n:num1){
                res+=map.getOrDefault(tot-n,0);
            }
            return res;
        }
    }
}
