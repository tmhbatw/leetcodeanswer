package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1824 {

    public int minSideJumps(int[] obstacles) {
        int[] cur=new int[3];
        cur[0]=1;
        cur[2]=1;

        int obstacle=Integer.MAX_VALUE/2;

        int pre=-1;
        for(int num:obstacles){
            //System.out.println(Arrays.toString(cur));

            if(num==0){
                pre=-1;
                continue;
            }

            int[] nextCur=new int[3];
            int obstacleIndex=num-1;
            int index1=(obstacleIndex+2)%3;
            int index2=(obstacleIndex+1)%3;
            nextCur[obstacleIndex] = obstacle;

            if(index1==pre)
                nextCur[index1]=cur[index2]+1;
            else
                nextCur[index1]=Math.min(cur[index1],Math.min(cur[index2],cur[obstacleIndex])+1);

            if(index2==pre)
                nextCur[index2]=cur[index1]+1;
            else
                nextCur[index2]=Math.min(cur[index2],Math.min(cur[index1],cur[obstacleIndex])+1);

            cur=nextCur;
            pre= num-1;
        }
        return Math.min(cur[0],Math.min(cur[1],cur[2]));
    }
}
