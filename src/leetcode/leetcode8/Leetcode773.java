package leetcode.leetcode8;

import java.util.*;

public class Leetcode773 {

    int target=123450;
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int slidingPuzzle(int[][] board) {
        int[] start=getStart(board);
        Set<Integer> set=new HashSet<>();
        int startType=getTarget(board);
        if(startType==target)
            return 0;
        Queue<int[][]> s=new LinkedList<>();
        Queue<int[]> s2=new LinkedList<>();
        s.add(board);
        s2.add(start);
        int distance=1;
        while(!s.isEmpty()){
            int size=s.size();
            while(size-->0) {
                int[][] cur = s.poll();
                int[] curStart = s2.poll();
                for (int[] next : nextPos) {
                    int ii = curStart[0] + next[0];
                    int jj = curStart[1] + next[1];
                    if (ii >= 0 && ii < 2 && jj >= 0 && jj < 3) {
                        int[][] nextBoard = new int[2][3];
                        for (int i = 0; i < 2; i++)
                            nextBoard[i] = cur[i].clone();
                        nextBoard[curStart[0]][curStart[1]] = nextBoard[ii][jj];
                        nextBoard[ii][jj] = 0;
                        int curr=getTarget(nextBoard);
                        System.out.print(curr+" ");
                        if(curr==target)
                            return distance;
                        if(set.contains(curr))
                            continue;
                        set.add(curr);
                        s.add(nextBoard);
                        s2.add(new int[]{ii, jj});
                    }
                }
            }
            System.out.println();
            distance++;
        }
        return -1;
    }

    private int[] getStart(int[][] board){
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==0)
                    return new int[]{i,j};
            }
        }
        return new int[]{0,0};
    }

    private int getTarget(int[][] board){
        int val=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++)
                val=val*10+board[i][j];
        }
        return val;
    }
}
