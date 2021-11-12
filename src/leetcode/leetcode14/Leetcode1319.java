package leetcode.leetcode14;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1319 {

    public int makeConnected(int n, int[][] connections) {
        int[] type=new int[n];
        for(int i=0;i<n;i++)
            type[i]=i;

        int count=0;
        for(int[] edge:connections){
            int type1=getType(type,edge[0]);
            int type2=getType(type,edge[1]);
            if(type1==type2) {
                count++;
                continue;
            }
            type[type1]=type2;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(getType(type,i));
        }
        if(set.size()>count+1)
            return -1;
        return set.size()-1;
    }

    private int getType(int[] type,int cur){
        if(cur==type[cur])
            return cur;
        return getType(type,type[cur]);
    }
}
