package leetcode.leetcode6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode529 {

    int[][] nextPos=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},
            {1,1},{1,0},{1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }

        Queue<int[]> q=new LinkedList<>();
        q.add(click);
        int row=board.length,col=board[0].length;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(board[cur[0]][cur[1]]!='E')
                continue;
            int nextMines=0;
            List<int[]> near=new ArrayList<>();

            for(int[] next:nextPos){
                int ii=next[0]+cur[0];
                int jj=next[1]+cur[1];
                if(ii>=0&&ii<row&&jj>=0&&jj<col){
                    if(board[ii][jj]=='M'||board[ii][jj]=='X')
                        nextMines++;
                    else if(board[ii][jj]=='E')
                        near.add(new int[]{ii,jj});
                }
            }
            if(nextMines>0){
                board[cur[0]][cur[1]]= (char) (nextMines+'0');
            }else {
                board[cur[0]][cur[1]]='B';
                q.addAll(near);
            }
        }
        return board;
    }
}
