package leetcode.leetcode11;

import java.util.*;

public class Leetcode1090 {
    public int largestValsFromLabels(int[] values, int[] labels,
                                     int numWanted, int useLimit) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<labels.length;i++){
            map.putIfAbsent(labels[i],new ArrayList<>());
            map.get(labels[i]).add(values[i]);
        }

        List<Integer> list=new ArrayList<>();
        for(int key:map.keySet()){
            List<Integer> l=map.get(key);
            Collections.sort(l);

            for(int j=l.size()-1;j>=Math.max(l.size()-useLimit,0);j--){
                list.add(l.get(j));
            }
        }

        Collections.sort(list);
        int result=0;
        for(int j=list.size()-1;j>=Math.max(0,list.size()-numWanted);j--)
            result+=list.get(j);
        return result;
    }

}
