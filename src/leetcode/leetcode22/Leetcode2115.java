package leetcode.leetcode22;

import java.util.*;

public class Leetcode2115 {
    public List<String> findAllRecipes(String[] recipes,
                                       List<List<String>> ingredients,
                                       String[] supplies) {
        Map<String,List<String>> map=new HashMap<>();
        Map<String,Integer> time=new HashMap<>();

        for(int i=0;i<recipes.length;i++){
            List<String> list=ingredients.get(i);
            for(String pre:list){
                map.putIfAbsent(pre,new ArrayList<>());
                map.get(pre).add(recipes[i]);
            }
            time.put(recipes[i],list.size());
        }

        Queue<String> q=new LinkedList<>(Arrays.asList(supplies));
        List<String> result=new ArrayList<>();
        while(!q.isEmpty()){
            String cur=q.poll();
            List<String> list=map.getOrDefault(cur,new ArrayList<>());

            for(String post:list){
                if (time.containsKey(post)) {
                    time.put(post,time.get(post)-1);
                    if(time.get(post)==0){
                        result.add(post);
                        q.add(post);
                    }
                }
            }
        }
        return result;
    }
}
