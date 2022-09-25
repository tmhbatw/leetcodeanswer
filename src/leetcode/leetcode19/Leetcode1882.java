package leetcode.leetcode19;

import java.util.PriorityQueue;

public class Leetcode1882 {

    class Server{
        int wedge;
        int freeTime;
        int index;
        public Server(int wedge, int freeTime,int index){
            this.wedge=wedge;
            this.freeTime=freeTime;
            this.index=index;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> freeServerQueue=new PriorityQueue<>((o1,o2)->{
            if(o1.wedge==o2.wedge)
                return o1.index-o2.index;
            return o1.wedge-o2.wedge;
        });
        for(int i=0;i<servers.length;i++)
            freeServerQueue.add(new Server(servers[i],0,i));
        PriorityQueue<Server> workServerQueue=new PriorityQueue<>((o1,o2)->o1.freeTime-o2.freeTime);
        int t=0;

        int[] result=new int[tasks.length];
        for(int i=0;i<tasks.length;i++){
            t=Math.max(t,i);
            if(freeServerQueue.isEmpty()){
                t=Math.max(t,workServerQueue.peek().freeTime);
            }
            while(!workServerQueue.isEmpty()&&workServerQueue.peek().freeTime<=t)
                freeServerQueue.add(workServerQueue.poll());
            Server cur=freeServerQueue.poll();
            result[i]=cur.index;
            cur.freeTime=t+tasks[i];
            workServerQueue.add(cur);
        }

        return result;
    }
}
