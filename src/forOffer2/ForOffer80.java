package forOffer2;

import java.util.ArrayList;
import java.util.List;

public class ForOffer80 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k,new ArrayList<>());
        return result;
    }

    private void dfs(int i,int n,int k,List<Integer> list){
        if(i>n){
            if(k==0){
                result.add(list);
            }
            return;
        }
        if(k>0){
            List<Integer> newList=new ArrayList<>(list);
            newList.add(i);
            dfs(i+1,n,k-1,newList);
        }
        dfs(i+1,n,k,list);
    }
}
