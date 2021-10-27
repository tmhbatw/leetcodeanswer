package leetcode.leetcode18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1782 {

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        Map<Integer,Integer> del=new HashMap<>();
        int[] num=new int[n+1];
        for(int[] edge:edges){
            int min=Math.min(edge[0],edge[1]);
            int max=Math.max(edge[0],edge[1]);
            if(min==max)
                continue;
            num[min]++;
            num[max]++;
            del.put(min*20001+max,del.getOrDefault(min*20001+max,0)+1);
        }

        int[] res=new int[queries.length];
        int[] time=num.clone();
        Arrays.sort(time);
        System.out.println(Arrays.toString(time));

        for(int i=0;i<res.length;i++){
            int cur=0;
            int j=n+1;
            for(int l=1;l<=n;l++){
                while(j>l+1&&time[j-1]+time[l]>queries[i])
                    j--;
                cur+=Math.min(n-l,n-j+1);
            }

            System.out.println(cur);

            for(int edge:del.keySet()){
                int ii=edge/20001;
                int jj=edge%20001;
                if(num[ii]+num[jj]>queries[i]&&num[ii]+num[jj]-del.get(edge)<=queries[i])
                    cur--;
            }
            res[i]=cur;
        }
        return res;
    }
}
