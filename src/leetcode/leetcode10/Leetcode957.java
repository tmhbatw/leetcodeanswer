package leetcode.leetcode10;

import java.util.HashMap;
import java.util.Map;

public class Leetcode957 {

    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(getType(cells),0);
        for(int i=1;i<=n;i++){
            cells=getNextDay(cells);
            int t=getType(cells);
            if(map.containsKey(t)){
                int start=map.get(t);
                int key=i-start;
                n=(n-start)%key+start;
            }else
                map.put(t,i);
        }

        int t=0;
        for(int key:map.keySet()){
            if(map.get(key)==n)
               t=key;
        }

        int[] res=new int[cells.length];
        for(int i=0;i<res.length;i++){
            if(t%2==1)
                res[i]=1;
            t/=2;
        }
        return res;
    }

    private int[] getNextDay(int[] cells){
        int[] next=new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            if(cells[i-1]==cells[i+1])
                next[i]=1;
        }
        return next;
    }

    private int getType(int[] cells){
        int type=0;
        for(int i=0;i<cells.length;i++){
            if(cells[i]==1)
                type+=1<<i;
        }
        return type;
    }


}
