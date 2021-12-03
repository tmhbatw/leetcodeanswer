package leetcode.leetcode20;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1980 {

    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set=new HashSet<>();
        for(String num:nums){
            set.add(Integer.parseInt(num,2));
        }

        for(int i=0;i<=17;i++){
            if(!set.contains(i)){
                return getRes(i,nums[0].length());
            }
        }
        return "000000";
    }

    private String getRes(int num,int n){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(num%2);
            num/=2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        String s="1001";
        System.out.println(Integer.parseInt(s,2));
    }
}
