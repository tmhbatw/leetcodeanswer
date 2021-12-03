package leetcode.leetcode13;

import java.util.*;

public class Leetcode1257 {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String,String> map=new HashMap<>();
        for(List<String> list:regions){
            for(int i=1;i<list.size();i++)
                map.put(list.get(i),list.get(0));
        }

        Set<String> set=new HashSet<>();
        set.add(region1);
        while(map.containsKey(region1)){
            set.add(map.get(region1));
            region1=map.get(region1);
        }

        while(!set.contains(region2)){
            region2=map.get(region2);
        }
        return region2;
    }
}
