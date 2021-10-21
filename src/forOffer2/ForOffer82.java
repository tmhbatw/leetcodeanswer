package forOffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForOffer82 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,0,target,new ArrayList<>());
        return result;
    }

    private void dfs(int[] can,int index,int curSum,int target,List<Integer> list){
        if(curSum==target){
            result.add(list);
            return;
        }
        if(index==can.length||curSum+can[index]>target)
            return;
        List<Integer> newList=new ArrayList<>(list);
        newList.add(can[index]);
        dfs(can,index+1,curSum+can[index],target,newList);

        while(index<can.length-1&&can[index]==can[index+1])
            index++;
        dfs(can,index+1,curSum,target,list);
    }
}
