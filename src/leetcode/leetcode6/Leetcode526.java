package leetcode.leetcode6;

import java.util.*;

public class Leetcode526 {

    int result=0;
    List<List<Integer>> list=new ArrayList<>();
    public int countArrangement(int n) {
        for(int i=1;i<=n;i++){
            List<Integer> res=new ArrayList<>();
            for(int j=1;j<=n;j++){
                if(i%j==0||j%i==0)
                    res.add(j);
            }
            list.add(res);
        }
        boolean[] reached=new boolean[n+1];
        dfs(reached,1,n);
        return result;
    }

    private void dfs(boolean[] reached,int index,int n){
        if(index>n){
            result++;
            return;
        }
        List<Integer> l=list.get(index-1);
        for(int next:l){
            if(!reached[next]){
                reached[next]=true;
                dfs(reached,index+1,n);
                reached[next]=false;
            }
        }
    }




}
