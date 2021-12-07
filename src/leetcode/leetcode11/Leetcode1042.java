package leetcode.leetcode11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode1042 {

    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res=new int[n];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());

        for(int[] path:paths){
            int min=Math.min(path[0],path[1])-1;
            int max=Math.max(path[0],path[1])-1;
            list.get(max).add(min);
        }

        for(int i=0;i<n;i++){
            List<Integer> l=list.get(i);
            List<Integer> type=new ArrayList<>();
            for(int index:l)
                type.add(res[index]);
            res[i]=getType(type);
        }
        return res;
    }

    private int getType(List<Integer> type){
        Collections.sort(type);
        int res=1;
        for(int i=0;i<type.size();i++){
            if(res==type.get(i))
                res++;
            else if(res<type.get(i))
                return res;
        }
        return res;
    }


}
