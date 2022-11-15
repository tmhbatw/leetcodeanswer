package leetcode.leetcode25;

import datastructure.TreeNode;

import java.util.*;

public class Leetcode2471 {

    private int getRes(List<Integer> list){
        List<Integer> newList=new ArrayList<>(list);
        Collections.sort(newList);

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<newList.size();i++){
            map.put(newList.get(i),i);
        }

        int result=0;
        boolean[] reached=new boolean[list.size()];
        for(int i=0;i<list.size();i++){
            if(reached[i])
                continue;
            int cur=i;
            int add=0;
            while(i!=map.get(list.get(cur))){
                cur=map.get(list.get(cur));
                reached[cur]=true;
                add++;
            }
            result+=add;
        }
        return result;
    }


}
