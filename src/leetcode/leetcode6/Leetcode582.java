package leetcode.leetcode6;

import java.util.*;

public class Leetcode582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<pid.size();i++){
            map.putIfAbsent(ppid.get(i),new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> result=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(kill);
        result.add(kill);

        while(!q.isEmpty()){
            int cur=q.poll();
            for(int n:map.getOrDefault(cur,new ArrayList<>())){
                result.add(n);
                q.add(n);
            }
        }
        return result;
    }

}
