package leetcode.leetcode22;

public class Leetcode2152 {

    int result=Integer.MAX_VALUE;
    public int minimumLines(int[][] points) {
        dfs(0,0,new boolean[points.length],points);
        return result;
    }

    private void dfs(int i,int time,boolean[] reached,int[][] points){
        if(time>=result)
            return;

        if(i==reached.length){
            result=Math.min(result,time);
            return;
        }

        if(reached[i]){
            dfs(i+1,time,reached,points);
            return;
        }

        for(int j=i+1;j<reached.length;j++){
            if(reached[j])
                continue;
            boolean[] nextReached=reached.clone();
            nextReached[j]=true;
            for(int k=j+1;k<reached.length;k++){
                if(isMumLines(points[i],points[j],points[k]))
                    nextReached[k] = true;
            }
            dfs(i+1,time+1,nextReached,points);
        }
        dfs(i+1,time+1,reached,points);
    }

    private boolean isMumLines(int[] point1,int[] point2,int[] point3){
        return (point2[0]-point1[0])*(point3[1]-point2[1])
                ==(point3[0]-point2[0])*(point2[1]-point1[1]);
    }

}
