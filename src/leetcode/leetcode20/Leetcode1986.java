package leetcode.leetcode20;

public class Leetcode1986 {

    int result=Integer.MAX_VALUE;
    public int minSessions(int[] tasks, int sessionTime) {
        result=tasks.length;
        dfs(tasks,0,0,sessionTime,new int[tasks.length]);

        return result;
    }

    private void dfs(int[] tasks,int i,int time,int sessionTime,int[] t){
        if(result<=time)
            return;
        if(i==tasks.length){
            result=time;
            return;
        }

        for(int j=0;j<time;j++){
            if(t[j]+tasks[i]<=sessionTime){
                t[j]+=tasks[i];
                dfs(tasks,i+1,time,sessionTime,t);
                t[j]-=tasks[i];
            }
        }
        t[time]+=tasks[i];
        dfs(tasks,i+1,time+1,sessionTime,t);
        t[time]-=tasks[i];
    }


}
