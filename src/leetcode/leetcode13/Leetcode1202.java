package leetcode.leetcode13;

import java.util.*;

public class Leetcode1202 {
    int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length=s.length();
        int[] type=new int[length];
        this.rank=new int[length];
        Arrays.fill(rank,1);
        for(int i=0;i<type.length;i++)
            type[i]=i;
        for(List<Integer> pair:pairs){
            int max=Math.max(pair.get(0),pair.get(1));
            int min=Math.min(pair.get(0),pair.get(1));
            int t1=getType(min,type);
            int t2=getType(max,type);
            if(t1!=t2){
                if(rank[t1]<rank[t2]){
                    int temp=t1;
                    t1=t2;
                    t2=temp;
                }
                type[t2]=t1;
                rank[t1]+=rank[t2];
            }
        }

        Map<Integer,List<Character>> m1=new HashMap<>();
        Map<Integer,List<Integer>> m2=new HashMap<>();
        for(int i=0;i<type.length;i++){
            int t=getType(type[i],type);
            m1.putIfAbsent(t,new ArrayList<>());
            m2.putIfAbsent(t,new ArrayList<>());
            m1.get(t).add(s.charAt(i));
            m2.get(t).add(i);
        }

        char[] res=new char[s.length()];
        for(int key:m1.keySet()){
            List<Character> l1=m1.get(key);
            List<Integer> l2=m2.get(key);
            Collections.sort(l1);
            for(int i=0;i<l1.size();i++){
                res[l2.get(i)]=l1.get(i);
            }
        }
        return new String(res);
    }

    private int getType(int cur,int[] type){
        if(type[cur]==cur)
            return cur;
        return getType(type[cur],type);
    }
}
