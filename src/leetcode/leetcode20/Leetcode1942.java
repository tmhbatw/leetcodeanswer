package leetcode.leetcode20;

import java.sql.Array;
import java.util.*;

public class Leetcode1942 {

    class Friend{
        int arrive;
        int leave;
        int i;
        public Friend(int arrive,int leave,int i){
            this.arrive=arrive;
            this.leave=leave;
            this.i=i;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        Friend[] friends=new Friend[times.length];
        for(int i=0;i<friends.length;i++)
            friends[i]=new Friend(times[i][0],times[i][1],i);

        Arrays.sort(friends,(o1,o2)->{
            if(o1.arrive==o2.arrive)
                return o1.leave-o2.leave;
            return o1.arrive-o2.arrive;
        });

        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<times.length;i++)
            set.add(i);
        Map<Integer,Integer> map=new HashMap<>();
        Queue<Friend> q=new PriorityQueue<>(Comparator.comparingInt(o -> o.leave));

        for (Friend friend : friends) {
            while (!q.isEmpty() && q.peek().leave <= friend.arrive) {
                set.add(map.get(q.poll().i));
            }

            int cur = set.pollFirst();
            map.put(friend.i, cur);
            q.add(friend);
            if (friend.i == targetFriend)
                return cur;
        }

        return -1;
    }
}
