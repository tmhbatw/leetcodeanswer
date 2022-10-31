package leetcode.leetcode25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2456 {

    public List<List<String>> mostPopularCreator(String[] creators,
                                                 String[] ids, int[] views) {
        Map<String,Long> score=new HashMap<>();
        Map<String,String> idMap=new HashMap<>();
        Map<String,Integer> viewMap=new HashMap<>();
        for(int i=0;i<creators.length;i++){
            score.put(creators[i],score.getOrDefault(creators[i],0L)+views[i]);
            if(viewMap.getOrDefault(creators[i],-1)<views[i]||
                viewMap.getOrDefault(creators[i],-1)==views[i]&&
                        idMap.get(creators[i]).compareTo(ids[i])>0){
                idMap.put(creators[i],ids[i]);
                viewMap.put(creators[i],views[i]);
            }
        }

        List<List<String>> result=new ArrayList<>();
        long max=0;
        for(String creator:score.keySet()){
            if(score.get(creator)>max){
                max=score.get(creator);
                result=new ArrayList<>();
            }
            if(max==score.get(creator)){
                List<String> cur=new ArrayList<>();
                cur.add(creator);
                cur.add(idMap.get(creator));
                result.add(cur);
            }
        }

        return result;
    }


}
