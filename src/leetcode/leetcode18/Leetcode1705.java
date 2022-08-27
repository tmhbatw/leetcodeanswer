package leetcode.leetcode18;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1705 {

    public int eatenApples(int[] apples, int[] days) {
        int i=0;
        int result =0;
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for(;i<apples.length;i++){
            if(apples[i]>0){
                q.add(new int[]{apples[i],days[i]+i-1});
            }
            while(!q.isEmpty()&&q.peek()[1]<i)
                q.poll();
            if(!q.isEmpty()){
                q.peek()[0]--;
                result++;
                if(q.peek()[0]==0)
                    q.poll();
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[1]<i)
                continue;
            int canEat=Math.min(cur[0],cur[1]-i+1);
            i+=canEat;
            result+=canEat;
        }

        return result;
    }
}
