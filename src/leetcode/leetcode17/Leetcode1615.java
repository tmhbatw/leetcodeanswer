package leetcode.leetcode17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1615 {

    Set<Integer> set=new HashSet<>();
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(i,0);

        for(int[] road:roads){
            map.put(road[0],map.get(road[0])+1);
            map.put(road[1],map.get(road[1])+1);
            set.add(getType(road[0],road[1]));
        }

        int result=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cur=map.get(i)+map.get(j);
                if(set.contains(getType(i,j)))
                    cur--;
                result=Math.max(result,cur);
            }
        }
        return result;
    }

    private int getType(int i,int j){
        int min=Math.min(i,j);
        int max=Math.max(i,j);
        return min*101+max;
    }
}
