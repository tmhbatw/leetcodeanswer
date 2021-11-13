package leetcode.leetcode10;

import java.util.HashMap;
import java.util.Map;

public class Leetcode974 {

    public int subarraysDivByK(int[] nums, int k) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int num:nums){
            sum+=num;
            int mod=getMod(sum,k);
            count+=map.getOrDefault(mod,0);
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        return count;
    }

    private int getMod(int num, int k){
        if(num<0){
            num+=-num/k*k+k;
        }
        return num%k;
    }

    public static void main(String[] args){
        System.out.println(new Leetcode974().getMod(-1,5));
    }
}
