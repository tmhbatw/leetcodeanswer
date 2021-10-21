package forOffer2;

import java.util.*;

public class ForOffer84 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        for(int cur:nums)
            list.add(cur);
        dfs(list,0);
        return result;
    }

    private void dfs(List<Integer> list,int index){
        if(index==list.size()){
            result.add(list);
            return;
        }
        Set<Integer> set=new HashSet<>();
        set.add(list.get(index));
        for(int i=index+1;i<list.size();i++){
            if(!set.contains(list.get(i))){
                set.add(list.get(i));
                List<Integer> newList=new ArrayList<>(list);
                int temp=newList.get(i);
                newList.set(i,newList.get(index));
                newList.set(index,temp);
                dfs(newList,index+1);
            }
        }
        dfs(list,index+1);
    }
}
