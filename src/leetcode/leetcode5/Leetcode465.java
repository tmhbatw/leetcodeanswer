package leetcode.leetcode5;

import java.util.HashMap;
import java.util.Map;

public class Leetcode465 {

    int result=Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int[] transaction :transactions){
            map.put(transaction[0],map.getOrDefault(transaction[0],0)+transaction[2]);
            map.put(transaction[1],map.getOrDefault(transaction[1],0)-transaction[2]);
        }
        int[] num = new int[map.size()];
        int index=0;
        for(int key:map.keySet()){
            num[index++]=map.get(key);
        }
        dfs(num,0,0);
        return result;
    }

    private void dfs(int[] num,int index,int cur){
        if(cur>result)
            return;
        if(index==num.length){
            result=Math.min(cur,result);
            return;
        }

        if(num[index]==0)
            dfs(num,index+1,cur);
        else{
            for(int j=index+1;j<num.length;j++){
                if(num[index]<0&&num[j]>0||num[index]>0&&num[j]<0){
                    num[j] += num[index];
                    dfs(num,index+1,cur+1);
                    num[j] -= num[index];
                }
            }
        }
    }
}
