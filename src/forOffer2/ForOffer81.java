package forOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForOffer81 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target,0,new ArrayList<>());
        return result;
    }

    private void dfs(int[] can,int index,int target,int sum, List<Integer> list){
        if(sum==target){
            result.add(list);
            return;
        }
        if(index==can.length||can[index]+sum>target)
            return;
        List<Integer> newList=new ArrayList<>(list);
        newList.add(can[index]);
        dfs(can,index,target,sum+can[index],newList);

        dfs(can,index+1,target,sum,list);
    }
}
