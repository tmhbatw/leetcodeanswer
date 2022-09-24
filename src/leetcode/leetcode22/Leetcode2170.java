package leetcode.leetcode22;

import java.util.*;

public class Leetcode2170 {

    public int minimumOperations(int[] nums) {
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                map1.put(nums[i], map1.getOrDefault(nums[i],0)+1);
            }else{
                map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
            }
        }
        List<Map.Entry<Integer,Integer>> l1=getList(map1);
        List<Map.Entry<Integer,Integer>> l2=getList(map2);

        if(!Objects.equals(l1.get(0).getKey(), l2.get(0).getKey()))
            return nums.length-(l1.get(0).getValue()+l2.get(0).getValue());

        int max=Math.max(l1.get(0).getValue(),l2.get(0).getValue());
        if(l1.size()>1){
            max=Math.max(max,l1.get(1).getValue()+l2.get(0).getValue());
        }
        if(l2.size()>1){
            max=Math.max(max,l1.get(0).getValue()+l2.get(1).getValue());
        }
        return nums.length-max;
    }

    private List<Map.Entry<Integer,Integer>> getList(Map<Integer,Integer> map){
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>();
        for(Map.Entry entry:map.entrySet())
            list.add(entry);
        Collections.sort(list,(o1,o2)-> o2.getValue()-o1.getValue());
        return list;
    }

}
