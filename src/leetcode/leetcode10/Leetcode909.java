package leetcode.leetcode10;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode909 {

    public int snakesAndLadders(int[][] board) {
        int n =board.length;
        boolean[] reached=new boolean[n*n+1];
        reached[1]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(1);

        int dis=0;
        while(!q.isEmpty()){
            dis++;
            int size=q.size();
            while(size-->0){
                int cur = q.poll();
                for(int j=cur+1;j<=Math.min(n*n,cur+6);j++){
                    int[] point = getPos(n,j);
                    int real = board[point[0]][point[1]]==-1?
                            j:board[point[0]][point[1]];

                    if(real==n*n){
                        return dis;
                    }

                    if(!reached[real]){
                        q.add(real);
                        reached[real]=true;
                    }

                }
            }
        }

        return -1;
    }

    private int[] getPos(int n,int cur){
        int row=n-(cur-1)/n-1;
        int col=(cur-1)%n;
        if((cur-1)/n%2==1){
            col = n-col-1;
        }
        return new int[]{row,col};
    }

}
