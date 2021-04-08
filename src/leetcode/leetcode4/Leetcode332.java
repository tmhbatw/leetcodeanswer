package leetcode.leetcode4;

import java.util.*;

public class Leetcode332 {
    /*Description
    *给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
    * 对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
    * */

    List<String> result=new ArrayList<>();
    Map<String,PriorityQueue<String>> map=new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets.size()==0)
            return result;
        for(List<String> cur:tickets){
            PriorityQueue<String> list=map.getOrDefault(cur.get(0),new PriorityQueue<>());
            list.add(cur.get(1));
            map.put(cur.get(0),list);
        }
        String start="JFK";
        dfs(start);
        Collections.reverse(result);
        return result;
    }

    public void dfs(String curr) {
        System.out.println(curr);
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        result.add(curr);
    }


}
