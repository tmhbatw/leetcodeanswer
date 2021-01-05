package leetcode2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode130 {
    /*Description
    * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
    * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
    * */

    public void solve(char[][] board) {
        if(board==null)
            return;
        int row=board.length,col=board[0].length;
        boolean[][] reached=new boolean[row][col];
        int[][] pos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'&&!reached[i][j]){
                    Set<int[]> set=new HashSet<>();
                    boolean change=true;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    set.add(new int[]{i,j});
                    reached[i][j]=true;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int[] nextPos:pos){
                            int ii=nextPos[0]+cur[0];
                            int jj=nextPos[1]+cur[1];
                            System.out.println(ii+" "+jj);
                            if(ii<0||ii>=row||jj<0||jj>=col)
                                change=false;
                            else {
                                if(reached[ii][jj]||board[ii][jj]=='X')
                                    continue;
                                set.add(new int[]{ii,jj});
                                q.add(new int[]{ii,jj});
                                reached[ii][jj]=true;
                            }
                        }
                    }
                    if(change){
                        for(int[] cur:set)
                            board[cur[0]][cur[1]]='X';
                    }
                }
            }
        }
    }
}
