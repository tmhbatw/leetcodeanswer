package leetcode7;

import java.util.*;

public class Leetcode692 {
    /*Description
    * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
    * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    * */

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String cur:words){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        PriorityQueue<Point> q=new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.time==o2.time)
                    return o2.word.compareTo(o1.word);
                return o1.time-o2.time;
            }
        });
        for(Map.Entry entry:map.entrySet()){
            Point cur=new Point((String)entry.getKey(),(int)entry.getValue());
            q.add(cur);
            if(q.size()>k)
                q.poll();
        }
        List<String> result=new ArrayList<>();
        while(!q.isEmpty()){
            result.add(0,q.poll().word);
        }
        return result;
    }

    private class Point{
        String word;
        int time;
        public Point(String word,int time){
            this.word=word;
            this.time=time;
        }
    }
}
