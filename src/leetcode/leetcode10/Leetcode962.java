package leetcode.leetcode10;

import java.util.TreeMap;

public class Leetcode962 {

    public int maxWidthRamp(int[] nums) {
        //map中value保存
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(map.floorKey(nums[i])!=null){
                result=Math.max(i-map.floorEntry(nums[i]).getValue(),result);
            }else
                map.put(nums[i],i);

        }

        return result;
    }

    public static void main(String[] args){
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(1,1);
        System.out.println(map.floorKey(1));
        System.out.println(map.lowerKey(1));
    }
}
