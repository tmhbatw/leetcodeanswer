package leetcode.leetcode9;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode841 {

    boolean[] res;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        res=new boolean[rooms.size()];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        res[0]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next:rooms.get(cur)){
                if(res[next])
                    continue;
                q.add(next);
                res[next]=true;
            }
        }
        for(boolean cur:res){
            if(!cur)
                return false;
        }
        return true;
    }
}
