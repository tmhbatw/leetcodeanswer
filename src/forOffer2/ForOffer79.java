package forOffer2;

import java.util.ArrayList;
import java.util.List;

public class ForOffer79 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums,int index,List<Integer> list){
        if(index==nums.length){
            result.add(list);
            return;
        }
        List<Integer> newList=new ArrayList<>(list);
        newList.add(nums[index]);
        dfs(nums,index+1,newList);
        dfs(nums,index+1,list);
    }
}
