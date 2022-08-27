package leetcode.leetcode18;

import java.util.*;
import java.util.jar.JarEntry;

public class Leetcode1733 {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> list=new ArrayList<>();
        for(int i=0;i<languages.length;i++){
            Set<Integer> s=new HashSet<>();
            for(int language:languages[i])
                s.add(language);
            list.add(s);
        }

        Set<Integer> s=getSet(friendships,list);
        Map<Integer,Integer> map=new HashMap<>();
        for(int ss:s){
            for(int l:list.get(ss-1)){
                map.put(l,map.getOrDefault(l,0)+1);
            }
        }

        int result = 0;
        for(int key:map.keySet())
            result=Math.max(result,map.get(key));
        return s.size()-result;
    }

    private Set<Integer> getSet(int[][] friendship,List<Set<Integer>> language){
        Set<Integer> list=new HashSet<>();
        for(int[] f:friendship) {
            Set<Integer> l1=language.get(f[0]-1);
            Set<Integer> l2=language.get(f[1]-1);
            boolean flag=false;
            for(int ll1:l1){
                if(l2.contains(ll1)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                list.add(f[0]);
                list.add(f[1]);
            }
        }
        return list;
    }


}
