package leetcode.leetcode18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1711 {

    int mod=1000000007;

    public int countPairs(int[] deliciousness) {
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();

        int[] num=new int[31];
        for(int i=0;i<31;i++){
            num[i]=1<<i;
        }

        for(int n:deliciousness){
            for(int i:num){
                result+=map.getOrDefault(i-n,0);
                result%=mod;
            }
            map.put(n,map.getOrDefault(n,0)+1);
        }

        return result;
    }

    public static void main(String[] args){
        new Leetcode1711().countPairs(new int[0]);
    }
}
