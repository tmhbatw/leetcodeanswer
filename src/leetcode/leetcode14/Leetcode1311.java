package leetcode.leetcode14;

import java.util.*;

public class Leetcode1311 {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n=friends.length;
        boolean[] reached=new boolean[n];
        reached[id]=true;

        Queue<Integer> q=new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()&&level-->0){
            int size=q.size();
            while(size-->0){
                int cur=q.poll();
                for(int f:friends[cur]){
                    if(!reached[f]){
                        reached[f]=true;
                        q.add(f);
                    }
                }
            }
        }

        Map<String,Integer> map=new HashMap<>();
        for(int num:q){
            for(String video:watchedVideos.get(num)){
                map.put(video,map.getOrDefault(video,0)+1);
            }
        }

        List<Map.Entry<String, Integer>> l = new ArrayList<>(map.entrySet());

        l.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return o1.getKey().compareTo(o2.getKey());
            return o1.getValue() - o2.getValue();
        });
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> e:l)
            result.add(e.getKey());

        return result;
    }
}
