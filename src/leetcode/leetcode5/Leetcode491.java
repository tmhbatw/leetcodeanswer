package leetcode.leetcode5;

import java.util.*;

public class Leetcode491 {

    List<List<Integer>> result=new ArrayList<>();
    Set<Long> exist=new HashSet<>();
    Map<Integer,Integer> map=new HashMap<>();
    int mod=1000000007;
    public List<List<Integer>> findSubsequences(int[] nums) {
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i+1);
        }
        dfs(nums,0,Integer.MIN_VALUE,0,new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums,int index,int pre,long type,List<Integer> list){
        System.out.println(list);
        if(index==nums.length)
            return;
        if(nums[index]>=pre){
            long curType=(type*17+map.get(nums[index]))%mod;
            System.out.println(curType+" "+exist);
            List<Integer> newList=new ArrayList<>(list);
            newList.add(nums[index]);

            if(!exist.contains(curType)&&newList.size()>=2){
                result.add(newList);
                exist.add(curType);
            }
            dfs(nums,index+1,nums[index],curType,newList);
        }
        dfs(nums,index+1,pre,type,list);
    }

    public static void main(String[] args){
        long cur=1;
        for(int i=2;i<=15;i++)
            cur*=i;
        System.out.println(cur);
    }

}
