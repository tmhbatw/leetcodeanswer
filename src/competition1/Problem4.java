package competition1;

import java.util.*;

public class Problem4 {

    //需要一步去重复
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        Map<Integer,Integer> set=new HashMap<>();

        int[] time=new int[n+1];

        for(int[] edge:edges){
            int num=edge[0]*n+edge[1];
            set.put(num,set.getOrDefault(num,0)+1);
                time[edge[0]]++;
                time[edge[1]]++;
        }
        int[] dp=new int[edges.length+2];
        for(int i=1;i<n+1;i++){

            for(int j=i+1;j<n+1;j++){
                int cur=time[i]+time[j];
                if(set.containsKey(i*n+j))
                    cur-=set.get(i*n+j);
                if(set.containsKey(j*n+i))
                    cur-=set.get(j*n+i);
                dp[cur]++;
            }
        }
        for(int i=dp.length-2;i>=0;i--){
            dp[i]+=dp[i+1];
        }
        int[] result=new int[queries.length];
        for(int i=0;i<result.length;i++){
            result[i]=dp[queries[i]+1];
        }
        return result;
    }
}
