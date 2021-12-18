package leetcode.leetcode11;

public class Leetcode1066 {

    int minDistance=Integer.MAX_VALUE;
    int[][] workers;
    int[][] bikes;
    public int assignBikes(int[][] workers, int[][] bikes) {
        this.workers=workers;
        this.bikes=bikes;
        dfs(0,0,0);

        return minDistance;
    }

    private void dfs(int i,int cur,int state){
        if(cur>minDistance)
            return ;
        if(i==workers.length){
            minDistance=cur;
            return;
        }

        for(int j=0;j<bikes.length;j++){
            if((state&(1<<j))==0){
                int add = Math.abs(bikes[j][0]-workers[i][0])+
                        Math.abs(bikes[j][1]-workers[i][1]);
                dfs(i+1,cur+add,state+(1<<j));
            }
        }
    }

}
