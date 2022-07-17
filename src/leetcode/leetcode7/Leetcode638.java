package leetcode.leetcode7;

import java.util.Arrays;
import java.util.List;

public class Leetcode638 {

    List<Integer> price;
    List<List<Integer>> special;
    int result=Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] need=new int[needs.size()];
        for(int i=0;i<needs.size();i++){
            need[i]=needs.get(i);
        }

        this.price=price;
        this.special=special;

        dfs(0,0,need);

        return result;
    }

    private void dfs(int index,int cur,int[] need){
        if(result<cur)
            return;

        if(index==special.size()){
            for(int i=0;i<need.length;i++){
                cur+=need[i]*price.get(i);
            }
            result=Math.min(cur,result);
            return;
        }

        dfs(index+1,cur,need.clone());
        int add=0;
        while(isBig(need,special.get(index))){
            add+=special.get(index).get(need.length);
            for(int i=0;i<need.length;i++)
                need[i]-=special.get(index).get(i);

            int[] nextNeed=need.clone();
            dfs(index+1,cur+add,nextNeed);
        }
    }

    private boolean isBig(int[] need,List<Integer> list){
        for(int i=0;i<need.length;i++){
            if(need[i]<list.get(i))
                return false;
        }

        return true;
    }
}
