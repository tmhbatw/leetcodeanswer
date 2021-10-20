package forOffer2;

import java.util.ArrayList;
import java.util.List;

public class ForOffer83 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
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
        for(int j=index+1;j<list.size();j++){
            List<Integer> newList=new ArrayList<>(list);
            int temp=newList.get(index);
            newList.set(index,list.get(j));
            newList.set(j,temp);
            dfs(newList,index+1);
        }

        dfs(list,index+1);
    }
}
