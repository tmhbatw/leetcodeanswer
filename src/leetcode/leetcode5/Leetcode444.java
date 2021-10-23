package leetcode.leetcode5;

import java.util.*;

public class Leetcode444 {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(seqs.size()==0)
            return false;
        int[] num=new int[org.length+1];
        Map<Integer,List<Integer>> map=new HashMap<>();

        for(List<Integer> l:seqs){
            for(int cur:l){
                if(cur>org.length||cur<=0)
                    return false;
            }
        }

        for(List<Integer> list:seqs){
            for(int i=0;i<list.size()-1;i++){
                num[list.get(i+1)]++;
                map.putIfAbsent(list.get(i),new ArrayList<>());
                map.get(list.get(i)).add(list.get(i+1));
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<num.length;i++){
            if(num[i]==0)
                q.add(i);
        }

        int index=0;
        while(!q.isEmpty()){
            if(q.size()!=1)
                return false;
            int cur=q.poll();
            if(cur!=org[index++])
                return false;
            List<Integer> next=map.getOrDefault(cur,new ArrayList<>());

            for(int n:next){
                num[n]--;
                if(num[n]==0)
                    q.add(n);
            }
        }

        return index==org.length;
    }
}
