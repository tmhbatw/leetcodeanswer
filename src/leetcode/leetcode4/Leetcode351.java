package leetcode.leetcode4;

import java.util.HashMap;
import java.util.Map;

public class Leetcode351 {


    int result=0;
    Map<Integer,Integer> map=getRepeatMap();
    public int numberOfPatterns(int m, int n) {
        dfs(-100,n,m,0,new boolean[9]);
        return result;
    }

    private void dfs(int pre,int m,int n,int cur,boolean[] reached){
        if(cur==m) {
            result++;
            return;
        }
        if(cur>=n)
            result++;
        for(int i=0;i<reached.length;i++){
            if(!reached[i]){
                int t=pre*10+i;
                if(!map.containsKey(t)||reached[map.get(t)]){
                    reached[i]=true;
                    dfs(i,m,n,cur+1,reached);
                    reached[i]=false;
                }
            }
        }
    }

    private Map<Integer,Integer> getRepeatMap(){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(2,1);
        map.put(20,1);
        map.put(6,3);
        map.put(60,3);
        map.put(8,4);
        map.put(80,4);
        map.put(17,4);
        map.put(71,4);
        map.put(26,4);
        map.put(62,4);
        map.put(28,5);
        map.put(82,5);
        map.put(35,4);
        map.put(53,4);
        map.put(68,7);
        map.put(86,7);
        return map;
    }

}
