package leetcode.leetcode22;

import java.util.*;

public class Leetcode2121 {
    public long[] getDistances(int[] arr) {
        long[] result=new long[arr.length];

        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        for(int key:map.keySet()){
            List<Integer> list=map.get(key);
            long first=0;
            for(int i=1;i<list.size();i++){
                first+=list.get(i)-list.get(0);
            }

            result[list.get(0)] = first;

            for(int i=1;i<list.size();i++){
                first -= (long) (list.get(i) - list.get(i - 1)) *(list.size()-i-i);
                result[list.get(i)]=first;
            }

        }

        return result;
    }

    public static void main(String[] args){
        int[] arr=new int[]{10,5,10,10};

        System.out.println(Arrays.toString(new Leetcode2121().getDistances(arr)));
    }
}
